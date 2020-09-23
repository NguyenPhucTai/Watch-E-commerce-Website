package phuctai.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterForm {

	@NotBlank(message = "You must input Username")
	private String username;
	

	@NotBlank(message = "You must input Password")
	private String password;
	
	@NotBlank(message = "You must input your Fullname")
	private String fullName;
	
	@NotBlank(message = "You must input Email")
    @Email(message = "Email should be valid")
	private String email;
    
	@NotBlank(message = "You must input phone number")
	private String phoneNumber;
	
	@NotBlank(message = "You must input address")
	private String address;
	

	public RegisterForm() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "RegisterForm [username=" + username + ", password=" + password + ", fullName=" + fullName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", Address=" + address + "]";
	}
	
	
	
}
