package phuctai.service;

import org.springframework.stereotype.Service;

import phuctai.entity.Account;
import phuctai.form.RegisterForm;


public interface AccountService {
	void save(RegisterForm registerForm);
	Account findByUsername(String username);
	void save(Account acc);
}
