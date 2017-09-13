package model;

public class User {
	
	private String userName;
	private String passord;
	
	public User() {
		super();
	}
	
	public User(String userName, String passord) {
		super();
		this.userName = userName;
		this.passord = passord;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", passord=" + passord + "]";
	}

}
