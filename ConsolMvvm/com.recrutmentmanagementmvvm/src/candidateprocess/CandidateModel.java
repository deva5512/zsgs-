package candidateprocess;

import java.util.List;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Post;
import com.recrutmentmanagement.dto.Resume;

import repository.RecrutmentDb;

public class CandidateModel {

	public CandidateModel() {

	}

	private Candidate candidate;

	public void saveCandidate(Object obj) {
		candidate = (Candidate) obj;
	}

	public boolean getResumeStatus() {
		return candidate.isResume_status();
	}

	public List<Post> getPost() {
		return RecrutmentDb.getInstance().getPost();
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void changeUserDetails(String name, String pass) {
		if (name != null) {
			candidate.setName(name);
		} else {
			candidate.setPassword(pass);
		}
	}

	public void createResume(String name, String qualification, int yOP, String skill, long number, String mail) {
		Resume resume = new Resume(name, qualification, yOP, skill, number, mail);
		candidate.setResume(resume);
		candidate.setResume_status(true);
	}

}
