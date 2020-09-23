package phuctai.service;

import phuctai.entity.*;
import phuctai.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Account acc = accountRepository.findByUsername(username);
		if(acc == null)
			throw new UsernameNotFoundException(username);
		
		//GrantedAuthority
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(Role role : acc.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));			
		}
		
		return new org.springframework.security.core.userdetails.User(acc.getUsername(), acc.getPassword(),
				grantedAuthorities);
	}

	public Account getAccount(String username) {
	   	Account account = accountRepository.findByUsername(username);
	   	return account;
	}
	
	
}
