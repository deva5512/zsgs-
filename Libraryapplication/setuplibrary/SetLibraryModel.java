package com.library.setuplibrary;

public class SetLibraryModel {

	private String library_name;
	private String library_address;
	private SetLibraryControler setLibraryControler;

	public SetLibraryModel(SetLibraryControler setLibraryControler) {
		this.setLibraryControler = setLibraryControler;
	}

	public String getLibrary_address() {
		return library_address;
	}

	public void setLibrary_address(String library_address) {
		this.library_address = library_address;
	}

	public String getLibrary_name() {
		return library_name;
	}

	public void setLibrary_name(String library_name) {
		this.library_name = library_name;
	}

	public void verifyOnline(String user_name, String password) {
		if (user_name.equals("admin") && password.equals("123456")) {
			setLibraryControler.adminVerified();
		} else {
			setLibraryControler.verificationFailed("Missmatch User name or Password");
		}
	}

}
