package phuctai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import phuctai.entity.Account;
import phuctai.repository.AccountRepository;


@SpringBootApplication
public class WatchOnlineShoopingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WatchOnlineShoopingApplication.class, args);
	}

	@Autowired
	AccountRepository accRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
//		Account acc1 = new Account();
//		acc1.setUsername("admin001");
//		acc1.setPassword(passwordEncoder.encode("admin001"));
//		acc1.setFullName("Nguyen Van A");
//		acc1.setEmail("admin001@gmail.com");
//		acc1.setPhoneNumber("091111111111");
//		acc1.setAddress("123 AAA");
//		accRepository.save(acc1);
//		
//		
//		Account acc2 = new Account();
//		acc2.setUsername("admin002");
//		acc2.setPassword(passwordEncoder.encode("admin002"));
//		acc2.setFullName("Nguyen Van B");
//		acc2.setEmail("admin002@gmail.com");
//		acc2.setPhoneNumber("0922222222");
//		acc2.setAddress("123 BBB");
//		accRepository.save(acc2);
//		
//		Account acc3 = new Account();
//		acc3.setUsername("user001");
//		acc3.setPassword(passwordEncoder.encode("user001"));
//		acc3.setFullName("Nguyen Van C");
//		acc3.setEmail("user001@gmail.com");
//		acc3.setPhoneNumber("0933333333");
//		acc3.setAddress("123 CCC");
//		accRepository.save(acc3);
//		
//		Account acc4 = new Account();
//		acc4.setUsername("user002");
//		acc4.setPassword(passwordEncoder.encode("user002"));
//		acc4.setFullName("Nguyen Van D");
//		acc4.setEmail("user002@gmail.com");
//		acc4.setPhoneNumber("0944444444");
//		acc4.setAddress("123 DDD");
//		accRepository.save(acc4);
//		
	}

}
