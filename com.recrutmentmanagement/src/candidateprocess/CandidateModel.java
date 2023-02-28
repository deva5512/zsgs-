package candidateprocess;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Resume;

import repository.RecrutmentDb;

public class CandidateModel implements CandidateModelCallBack {

	public CandidateModel(CandidateModelControllerCall candidatecontroller) {
		this.candidatecontroller = candidatecontroller;
	}

	private CandidateModelControllerCall candidatecontroller;
	private Candidate candidate;

	@Override
	public void saveCandidate(Object obj) {
		candidate = (Candidate) obj;
	}

	@Override
	public void getResumeStatus() {
		if (candidate.isResume_status()) {
			candidatecontroller.viewJobs(RecrutmentDb.getInstance().getPost());
		} else {
			candidatecontroller.candidateUpdateResume("Kindly Update Your resume before looking for a job ");
		}
	}

	@Override
	public Candidate getCandidate() {
		return candidate;
	}

	@Override
	public void changeUserDetails(String name, String pass) {
		if (name != null) {
			candidate.setName(name);
		} else {
			candidate.setPassword(pass);
		}
	}

	@Override
	public void createResume(Resume resume) {
		candidate.setResume(resume);
		candidate.setResume_status(true);
	}

}
