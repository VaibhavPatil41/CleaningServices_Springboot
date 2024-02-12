package com.cleaningServices.entities;


import jakarta.persistence.*;


@Entity
@Table(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int login_id;
	
	@ManyToOne
    @JoinColumn(name = "role_id")
	Role roleid;
	
	@Column
	String username;
	
	@Column
	String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int login_id, Role roleid, String uname, String password) {
		super();
		this.login_id = login_id;
		this.roleid = roleid;
		this.username = uname;
		this.password = password;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public Role getRoleid() {
		return roleid;
	}

	public void setRoleid(Role roleid) {
		this.roleid = roleid;
	}

	public String getUsername() {
		return username;
	}

	public void setUname(String uname) {
		this.username = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
