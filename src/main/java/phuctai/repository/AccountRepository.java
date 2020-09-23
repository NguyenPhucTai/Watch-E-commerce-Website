package phuctai.repository;

import phuctai.entity.Account;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByUsername(String username);
	
	List<Account> findByRolesId(long rolesId);
	
	List<Account> findByRolesIdAndUsernameContaining(long roleId, String Username);
	
}
