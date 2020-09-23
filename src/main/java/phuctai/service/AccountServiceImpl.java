package phuctai.service;

import phuctai.repository.AccountRepository;
import phuctai.repository.RoleRepository;
import phuctai.form.RegisterForm;
import phuctai.entity.Account;
import phuctai.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(RegisterForm registerForm) {
		Account acc = new Account();
		acc.setUsername(registerForm.getUsername());
		acc.setPassword(bCryptPasswordEncoder.encode(registerForm.getPassword()));
		acc.setFullName(registerForm.getFullName());
		acc.setEmail(registerForm.getEmail());
		acc.setPhoneNumber(registerForm.getPhoneNumber());
		acc.setAddress(registerForm.getAddress());
		
		accountRepository.save(acc);
		
		Account newAcc = accountRepository.findByUsername(acc.getUsername());
		saveManyToMany(newAcc);
		
	}
	
	public void saveManyToMany(Account acc) {
		Role role = roleRepository.findByName("USER");
		
		acc.getRoles().add(role);
		accountRepository.save(acc);
		
	}

	@Override
	public Account findByUsername(String username) {
		Account acc = accountRepository.findByUsername(username);
		return acc;
	}

	@Override
	public void save(Account acc) {
		Role role = roleRepository.findByName("USER");
		
		acc.getRoles().add(role);
		accountRepository.save(acc);	
	}
	
	public List<Account> findAllByUserRole(){
		List<Account> list =  accountRepository.findByRolesId(2);
		return list;
	}

	public List<Account> listAll(String userKey) {
		if(userKey != null) {
			return accountRepository.findByRolesIdAndUsernameContaining(2, userKey); 
		}
		return accountRepository.findByRolesId(2);
	}

	public void deleteUserAccount(String username) {
		Account account = accountRepository.findByUsername(username);
		Role role = roleRepository.findByName("USER");
		account.getRoles().add(role);
		accountRepository.delete(account);
		
	}


}
