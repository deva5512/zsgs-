package com.recrutmentmanagement.login;

import java.util.List;
import java.util.Queue;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Post;

public interface LoginViewControllerCall {

	void checkForAdmin(String name, String pass);

	List<Post> viewPaymentHistory();

	Admin getAdmin();

	void changeAdminDetails(String name, String pass, long phno);

	Queue<String> getNotinfication();

	void registerCandidate(String name, String pass);

	void registerHr(String name, String pass, String organization);

	void hrLoginCredential(String name, String pass);

	void userLoignCredential(String name, String pass);

}
