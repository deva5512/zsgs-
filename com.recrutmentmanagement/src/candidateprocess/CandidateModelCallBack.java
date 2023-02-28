package candidateprocess;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Resume;

public interface CandidateModelCallBack {

	void saveCandidate(Object obj);

	void getResumeStatus();

	Candidate getCandidate();

	void changeUserDetails(String name, String pass);

	void createResume(Resume resume);

}
