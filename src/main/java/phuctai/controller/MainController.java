package phuctai.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import phuctai.entity.*;
import phuctai.form.CreateProductForm;
import phuctai.form.EditCategoryForm;
import phuctai.form.EditProductForm;
import phuctai.form.EditProfileForm;
import phuctai.form.RegisterForm;
import phuctai.repository.RoleRepository;
import phuctai.service.AccountServiceImpl;
import phuctai.service.CategoryService;
import phuctai.service.FileService;
import phuctai.service.ProductService;
import phuctai.service.SecurityServiceImplement;
import phuctai.service.UserDetailsServiceImpl;
import phuctai.utils.AccountUtils;

@Controller
public class MainController {

	private String staticUsername = null;

	@Autowired
	private AccountServiceImpl accountService;

	@Autowired
	private SecurityServiceImplement securityService;

	@Autowired
	private UserDetailsServiceImpl userDetailService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private FileService fileService;

	/* METHOD */

	//
	// METHOD: /Get current login account info
	public Account getAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetail = (UserDetails) principal;
		String username = userDetail.getUsername();
		Account account = userDetailService.getAccount(username);
		return account;
	}

	//
	// METHOD: /Check current login account condition
	private boolean validLogin(UserDetails userDetails) {
		return userDetails.isAccountNonExpired() && userDetails.isAccountNonLocked()
				&& userDetails.isCredentialsNonExpired() && userDetails.isEnabled();
	}

	/* PUBLIC CONTROLLER */
	//
	// GET: /Login
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login(RedirectAttributes attributes, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails && validLogin((UserDetails) principal)) {
			UserDetails userDetail = (UserDetails) principal;
			String role = null;
			for (GrantedAuthority grantedAuthority : userDetail.getAuthorities()) {
				role = grantedAuthority.toString();
			}
			Account account = userDetailService.getAccount(userDetail.getUsername());
			if (role.equals("ADMIN")) {
				attributes.addFlashAttribute("account", account);
				return "redirect:/admin";
			} else if (role.equals("USER")) {
				attributes.addFlashAttribute("account", account);
				return "redirect:/homepage";
			}
		}
		Account nonAcc = new Account();
		model.addAttribute("account", nonAcc);
		return "login";
	}

	//
	// GET: /Homepage
	@GetMapping("/homepage")
	public String showHomePage(Model model) {
		List<Product> list = productService.getProductListByTop6();
		model.addAttribute("productList", list);
		return "index";
	}


	/* ADMIN CONTROLLER */	
	// 
	// GET: /Admin /Admin Homepage
	@GetMapping("/admin")
	public String showAdminPage(Model model, @Param("productKey") String productKey, @Param("userKey") String userKey,
								@Param("categoryKey") String categoryKey) {
		Account acc = getAccount();
		model.addAttribute("account", acc);
		
		List<Category> listCategory = categoryService.listAll(categoryKey);
		model.addAttribute("categoryList", listCategory);
		
		List<Product> listProducts = productService.listAll(productKey);
		model.addAttribute("productList", listProducts);
		
		List<Account> listUsers = accountService.listAll(userKey);
		model.addAttribute("userList", listUsers);
		
		if(productKey != null) {
			return "admin/adminPage2";
		}else if(categoryKey != null) {
			return "admin/adminPage3";
		}else {
			return "admin/adminPage";
		}
	}

	//
	// GET: /Admin/Edit user profile
	@GetMapping("/admin/editprofile")
	public String showEditProfileByAdmin(Model model, @RequestParam(value = "username") String username) {
		Account adminAcc = getAccount();

		Account userAcc = accountService.findByUsername(username);

		EditProfileForm form = new EditProfileForm(userAcc);

		staticUsername = username;
		model.addAttribute("account", adminAcc);
		model.addAttribute("username", userAcc.getUsername());

		model.addAttribute("editProfileForm", form);
		return "admin/editprofilebyadmin";
	}

	//
	// POST: /Admin/Edit user profile
	@PostMapping("/editprofilebyadmin")
	public String processEditProfileByAdmin(@Valid EditProfileForm editProfileForm, BindingResult bindingResult,
			Model model, RedirectAttributes attributes) {
		Account acc = getAccount();
		if (bindingResult.hasErrors()) {
			model.addAttribute("account", acc);
			return "admin/editprofilebyadmin";
		}
		Account user = accountService.findByUsername(staticUsername);
		Account editAccount = new Account(user.getId(), user.getUsername(), user.getPassword(),
				editProfileForm.getFullName(), editProfileForm.getEmail(), editProfileForm.getPhoneNumber(),
				editProfileForm.getAddress());

		accountService.save(editAccount);
		return "redirect:/admin?userKey=" + editAccount.getUsername();
	}

	//
	// GET: /Admin/Delete user profile
	@GetMapping("/admin/deleteprofile")
	public String processDeleteAccountByAdmin(@RequestParam(value = "username") String username) {
		accountService.deleteUserAccount(username);
		return "redirect:/admin";
	}

	// GET: /Admin/Create new product
	@GetMapping("/admin/createproduct")
	public String showCreateProductPage(Model model) {
		List<Category> categoryList = categoryService.getAllCategory();
		CreateProductForm form = new CreateProductForm();
		model.addAttribute("createproductform", form);
		model.addAttribute("categoryList", categoryList);
		return "admin/createproductbyadmin";
	}

	//
	// POST: /Admin/Create new product
	@PostMapping("/createProduct")
	public String processCreateNewProduct(CreateProductForm createproductform,
			@RequestParam("file") MultipartFile file) {
		String productName = "";
		if (file.isEmpty() || file.getOriginalFilename().equals("")) {
			return "redirect:/admin/createproduct";
		} else {
			String storageLink = fileService.uploadFile(file);
			Product product = new Product(createproductform.getProductName(), createproductform.getProductDetail(),
					createproductform.getPrice(), storageLink);
			String categoryName = createproductform.getCateName();
			productService.save(product, categoryName);
			productName = product.getProductName();
		}	
		return "redirect:/admin?productKey=" + productName;
	}

	//
	// GET: /Admin/Edit product info
	@GetMapping("/admin/editproduct")
	public String showEditProductPage(Model model, @RequestParam(value = "product") String productName) {

		Product product = productService.findByProductName(productName);
		CreateProductForm form = new CreateProductForm(product);

		// Handle category
		List<Category> categoryList = categoryService.getAllCategory();
		String currentCate = "";
		for (Category cate : product.getCategories()) {
			currentCate = cate.getCateName();
		}
		List<Category> cateList = new ArrayList<>();
		for (Category cate : categoryList) {
			if (!cate.getCateName().equalsIgnoreCase(currentCate)) {
				cateList.add(cate);
			}
		}
		model.addAttribute("currentCate", currentCate);
		model.addAttribute("categoryList", cateList);
		model.addAttribute("createForm", form);
		return "admin/editproductbyadmin";
	}

	//
	// POST: /Admin/Edit product info
	@PostMapping("/editproduct")
	public String processEditProductByAdmin(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, CreateProductForm form) {

		String productName = "";
		if(file.isEmpty() || file.getOriginalFilename().equals("")) {
			Product product = new Product(form.getId(), form.getProductName(), form.getProductDetail(), form.getPrice(), form.getLinkImg());
			productService.save(product, form.getCateName());
			productName = product.getProductName();
		} else {
			String storageLink = fileService.uploadFile(file);
			Product product = new Product(form.getId(), form.getProductName(), form.getProductDetail(), form.getPrice(), storageLink);
			productService.save(product, form.getCateName());
			productName = product.getProductName();
		}
		return "redirect:/admin?productKey=" + productName;

	}
	
	//
	// GET: /Admin/Delete product
	@GetMapping("/admin/deleteproduct")
	public String processDeleteProductByAdmin(@RequestParam (value="product") String productName) {
		productService.deleteProduct(productName);
		return "redirect:/admin";
	}


	//
	// GET: /Admin/Create category
	@GetMapping("/admin/createcategory")
	public String showCreateCategoryPage() {
		return "admin/createcategorybyadmin";
	}
	
	//
	// POST: /Admin/Create category
	@PostMapping("/createcategory")
	public String processCreateCategoryByAdmin(@RequestParam (value="cateName") String cateName) {
		System.out.println(cateName);
		categoryService.save(cateName);
		return "redirect:/admin?categoryKey=" + cateName;
	}
		
	//
	// GET: /Admin/Edit category
	@GetMapping("/admin/editcategory")
	public String showEditCategoryByAdmin(@RequestParam (value="category") String cateName, Model model) {
		Category category = categoryService.findByCategoyName(cateName);
		EditCategoryForm form = new EditCategoryForm();
		form.setCateName(category.getCateName());
		form.setId(category.getId());
		model.addAttribute("editcategoryform", form);
		return "admin/editcategorybyadmin";
	}
	
	//
	// POST: /Admin/Edit category
	@PostMapping("/editcategory")
	public String processEditCategoryByAdmin(RedirectAttributes redirectAttributes, EditCategoryForm form) {
		System.out.println("Post: " + form.toString());
		Category category = new Category(form.getId(), form.getCateName());
		categoryService.save(category);
		return "redirect:/admin?categoryKey=" + category.getCateName();
	}
	
	//
	// GET: /Admin/Delete category
	@GetMapping("/admin/deletecategory")
	public String processDeleteCategoryByAdmin(@RequestParam (value="category") String categoryName) {
		categoryService.deleteCategory(categoryName);
		return "redirect:/admin";
	}

	
	
	
	/* USER CONTROLLER */
	//
	// GET: /User/Register
	@GetMapping("/register")
	public String showRegisterPage(Model model, RedirectAttributes attributes) {
		RegisterForm form = new RegisterForm();
		model.addAttribute("registerForm", form);
		return "user/register";
	}

	//
	// POST: /User/Register
	@PostMapping("/register")
	public String processRegister(@Valid RegisterForm registerForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			Account nonAcc = new Account();
			model.addAttribute("account", nonAcc);
			return "register";
		}

		accountService.save(registerForm);
		securityService.autoLogin(registerForm.getUsername(), registerForm.getPassword());
		return "redirect:/homepage";
	}

	//
	// GET: /User/View user profile
	@GetMapping("/profile")
	public String showProfilePage(Model model) {
		Account acc = getAccount();
		model.addAttribute("account", acc);

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetail = (UserDetails) principal;
		String role = null;
		for (GrantedAuthority grantedAuthority : userDetail.getAuthorities()) {
			role = grantedAuthority.toString();
		}
		model.addAttribute("role", role);
		return "user/userprofile";
	}
	
	//
	// GET: /User/Edit user profile
	@GetMapping("/editprofile")
	public String showEditProfile(Model model) {
		Account acc = getAccount();
		model.addAttribute("account", acc);

		EditProfileForm form = new EditProfileForm(acc);
		System.out.println("editform: " + form.toString());

		model.addAttribute("editProfileForm", form);
		return "user/editprofile";
	}

	//
	// POST: /User/Edit user profile
	@PostMapping("/editprofile")
	public String processEditProfile(@Valid EditProfileForm editProfileForm, BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {
		Account acc = getAccount();
		if (bindingResult.hasErrors()) {
			model.addAttribute("account", acc);
			return "editprofile";
		}

		Account editAccount = new Account(acc.getId(), acc.getUsername(), acc.getPassword(),
				editProfileForm.getFullName(), editProfileForm.getEmail(), editProfileForm.getPhoneNumber(),
				editProfileForm.getAddress());

		accountService.save(editAccount);
		attributes.addFlashAttribute("account", acc);
		return "redirect:/profile?name" + acc.getFullName();
	}

	// productlist
	@GetMapping("/productlist")
	public String productlist(Model model) {
		return "redirect:/productlist/1?sortField=id&sortDir=desc";
	}

	@GetMapping("/productlist/{pageNumb}")
	public String showproductlist(Model model, @PathVariable("pageNumb") int currentPage,
			@Param("sortField") String sortField, @Param("sortDir") String sortDir) {

		Page<Product> page = productService.findAllProduct(currentPage, sortField, sortDir);
		int totalItem = page.getNumberOfElements();
		int totalPage = page.getTotalPages();
		int nextPage = currentPage + 1;
		int previouspage = currentPage - 1;
		List<Product> list = page.getContent();
		String baseUrl = "/productlist/";
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItem", totalItem);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("productlist", list);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("previouspage", previouspage);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		return "view/shop";
	}

	// productdetail
	@GetMapping("/product_detail")
	public String productdt(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails && validLogin((UserDetails) principal)) {
			Account acc = getAccount();
			model.addAttribute("account", acc);
		} else {

			Account nonAcc = new Account();
			model.addAttribute("account", nonAcc);
		}

		
		return "redirect:/product_detail/1";
		
	}

	@GetMapping("/productlist/product_detail/{id}")
	public String productDetail(Model model, @PathVariable("id") Long id) {

		Optional<Product> pr = productService.findById(id);
		Product product = null;
		if (pr.isPresent()) {
			product = pr.get();
			String currentCate = "";

			for (Category i : product.getCategories()) {
				currentCate = i.getCateName();
			}
			model.addAttribute("currentCate", currentCate);

			model.addAttribute("product", product);
		}

		return "view/productdetail";
	}
	
}
