package phuctai.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/sale").hasAnyAuthority("SALE")
		.antMatchers("/user","/profile", "/editprofile").hasAuthority("USER")
		.antMatchers("/admin", "/admin/editprofile", "/admin/editproduct", "/admin/createproduct", "/admin/createcategory", "/admin/editcategory").hasAuthority("ADMIN")
		.anyRequest().permitAll()
				.and().formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
				.successHandler(successHandler).failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.and().logout()
					.logoutSuccessUrl("/login")
					.logoutUrl("/logout")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login")
				.permitAll();
				
		http.exceptionHandling().accessDeniedPage("/403");
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/register","/homepage", "/productlist/*").permitAll()
//		.antMatchers("/user","/profile", "/editprofile").hasAuthority("USER")
//		.antMatchers("/admin", "/admin/editprofile", "/admin/editproduct", "/admin/createproduct", "/admin/createcategory").hasAuthority("ADMIN")
//				.and().formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
//				.successHandler(successHandler).failureUrl("/login?error=true")
//				.usernameParameter("username")
//				.passwordParameter("password")
//				.and().logout()
//					.logoutSuccessUrl("/login")
//					.logoutUrl("/logout")
//					.invalidateHttpSession(true)
//					.clearAuthentication(true)
//					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//					.logoutSuccessUrl("/login")
//				.permitAll();
//
//		http.exceptionHandling().accessDeniedPage("/403");
//
//		
//	}
	
	
	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

}
