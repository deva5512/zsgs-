package candidateprocess;

import com.recrutmentmanagement.dto.Candidate;

public interface CandidateViewControllerCall {

	void saveCandidate(Object obj);

	void getResumeStatus();

	Candidate getCandidate();

	void changeUserDetails(String name, String pass);

	void createResume(String name, String qualification, int yOP, String skill, long number, String mail);

}
