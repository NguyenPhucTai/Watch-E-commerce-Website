package phuctai.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import phuctai.entity.Account;
import phuctai.repository.AccountRepository;


public class AccountUtils {

	@Autowired
	private static AccountRepository accountRepository;
	
	public static Account getAccount() {
		Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetail = (UserDetails) principal;
		String username = userDetail.getUsername();

		
    	Account account = accountRepository.findByUsername(username);
    	System.out.println(account);
    	return account;
	}
	
}
