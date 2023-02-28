package com.recrutmentmanagement.login;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;

public interface LoginViewCallBack {

	void verificationFailed(String error);

	void adminVerified(String name);

	void hrLogin(Hr hr);

	void candidateLogin(Candidate candidate);

}
