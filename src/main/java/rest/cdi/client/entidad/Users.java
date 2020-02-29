package rest.cdi.client.entidad;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties
public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String website;
	private String phone;
	private Address idAddress;
	private Company idCompany;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(Address idAddress) {
		this.idAddress = idAddress;
	}
	public Company getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Company idCompany) {
		this.idCompany = idCompany;
	}

	
	
} 
