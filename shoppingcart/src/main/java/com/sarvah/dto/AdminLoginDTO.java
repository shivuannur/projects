package com.sarvah.dto;



import org.apache.log4j.Logger;



public class AdminLoginDTO {
	static Logger log = Logger.getLogger(AdminLoginDTO.class);
	private int Id;
	private String name;
	private String email;
	
	/*public AdminLoginDTO(int Id,String name,String email)
	{
		this.Id=Id;
		this.name=name;
		this.email=email;
	}*/
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	private String password;

}
