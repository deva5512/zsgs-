package ecommercedto;

public class User {

	private String mail;
	private String name;
	
	public User(String mail , String name) {
		this.mail = mail;
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setName(String name) {
		this.name = name;
	}

}
