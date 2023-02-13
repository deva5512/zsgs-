package com.library.setuplibrary;

public class SetLibraryControler {

	private SetLibraryView setLibraryView;
	private SetLibraryModel setLibraryModel;

	public SetLibraryControler(SetLibraryView setLibraryView) {
		this.setLibraryView = setLibraryView;
		setLibraryModel = new SetLibraryModel(this);
	}

	public void verification(String user_name, String password) {
		setLibraryModel.verifyOnline(user_name, password);
	}

	public void verificationFailed(String error) {
		setLibraryView.verificationFailed(error);
	}

	public void adminVerified() {
		setLibraryView.adminVerified();
	}

	public void setLibraryDetails(String library_name, String library_address) {
		setLibraryModel.setLibrary_name(library_name);
		setLibraryModel.setLibrary_address(library_address);
	}

	public String viewLibraryAddress() {
		return setLibraryModel.getLibrary_address();
	}

	public String viewLibraryName() {
		return setLibraryModel.getLibrary_name();
	}

}
