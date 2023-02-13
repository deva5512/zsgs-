package com.library.managebook;

import java.util.HashMap;
import java.util.Map;

public class ManageBooksModel {

	private ManageBooksControler manageBooksControler;
	private Map<Integer, String> books;

	public ManageBooksModel(ManageBooksControler manageBooksControler) {
		this.manageBooksControler = manageBooksControler;
		books = new HashMap<>();
	}

	public void verifyOnline(String user_name, String password) {
		if (user_name.equals("admin") && password.equals("123456")) {
			manageBooksControler.adminVerified();
		} else {
			manageBooksControler.verificationFailed("Missmatch User name or Password");
		}
	}

	public void addbook(String book_name, int id) {
		if (books.containsKey(id)) {
			manageBooksControler.addingFailed("Id exist ");
		}
		books.put(id, book_name);
		manageBooksControler.addedSuccessfully();
	}

	public void removebook(int id) {
		if (books.containsKey(id)) {
			books.remove(id);
			manageBooksControler.bookRemovedSuccessfully();
		} else if (books.isEmpty()) {
			manageBooksControler.bookRemovedFailde("No book exist");
		} else {
			manageBooksControler.bookRemovedFailde("Id not found");
		}
	}

	public Map<Integer, String> viewBooks() {
		return books;
	}

}
