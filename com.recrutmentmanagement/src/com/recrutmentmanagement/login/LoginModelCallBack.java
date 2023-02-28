package com.recrutmentmanagement.login;

import java.util.List;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

public interface LoginModelCallBack {

	void checkForAdmin(String name, String pass);

	List<Post> getPostHistory();

	Admin getAdmin();

	void changeAdminDetails(String name, String pass, long phno);

	void registerCandidate(Candidate candidate);

	void registerHr(Hr hr);

	void hrLoginCredential(String name, String pass);

	void userLoignCredential(String name, String pass);

}
