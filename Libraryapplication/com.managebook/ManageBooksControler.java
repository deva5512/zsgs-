package com.library.managebook;

import java.util.Map;

public class ManageBooksControler {

	private ManageBooksView manageBooksView;
	private ManageBooksModel manageBooksModel;

	public ManageBooksControler(ManageBooksView manageBooksView) {
		this.manageBooksView = manageBooksView;
		this.manageBooksModel = new ManageBooksModel(this);
	}

	public void verify(String user_name, String password) {
		manageBooksModel.verifyOnline(user_name, password);
	}

	public void adminVerified() {
		manageBooksView.adminVerified();
	}

	public void verificationFailed(String error) {
		manageBooksView.verificationFailed(error);
	}

	public void addbook(String book_name, int id) {
		manageBooksModel.addbook(book_name, id);
	}

	public void addingFailed(String error) {
		manageBooksView.addingFailed(error);
	}

	public void addedSuccessfully() {
		manageBooksView.addedSuccessfully();
	}

	public void removebook(int id) {
		manageBooksModel.removebook(id);
	}

	public void bookRemovedSuccessfully() {
		manageBooksView.bookRemovedSuccessfully();
	}

	public void bookRemovedFailde(String error) {
		manageBooksView.bookRemovedFailde(error);
	}

	public Map<Integer, String> viewBooks() {
		return manageBooksModel.viewBooks();
	}
}
