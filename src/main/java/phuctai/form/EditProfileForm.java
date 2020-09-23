package phuctai.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import phuctai.entity.Account;

public class EditProfileForm {
	
	@NotBlank(message = "You must input your Fullname")
	private String fullName;
	
	@NotBlank(message = "You must input Email")
    @Email(message = "Email should be valid")
	private String email;
    
	@NotBlank(message = "You must input phone number")
	private String phoneNumber;
	
	@NotBlank(message = "You must input address")
	private String address;


	public EditProfileForm() {
		super();
		
	}

	public EditProfileForm(Account acc) {
		this.fullName = acc.getFullName();
		this.email = acc.getEmail();
		this.phoneNumber = acc.getPhoneNumber();
		this.address = acc.getAddress();
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
		return "EditProfileForm [fullName=" + fullName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
	
	
}
