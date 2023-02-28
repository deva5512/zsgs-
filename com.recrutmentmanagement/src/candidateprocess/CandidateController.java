package candidateprocess;

import java.util.List;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Post;
import com.recrutmentmanagement.dto.Resume;

public class CandidateController implements CandidateViewControllerCall, CandidateModelControllerCall {

	public CandidateController(CandidateViewCallBack candidateview) {
		this.candidateview = candidateview;
		this.candidatemodel = new CandidateModel(this);
	}

	private CandidateViewCallBack candidateview;
	private CandidateModelCallBack candidatemodel;

	@Override
	public void saveCandidate(Object obj) {
		candidatemodel.saveCandidate(obj);
	}

	@Override
	public void getResumeStatus() {
		candidatemodel.getResumeStatus();
	}

	@Override
	public void candidateUpdateResume(String error) {
		candidateview.candidateUpdateResume(error);
	}

	@Override
	public void viewJobs(List<Post> list) {
		candidateview.viewJobs(list);
	}

	@Override
	public Candidate getCandidate() {
		return candidatemodel.getCandidate();
	}

	@Override
	public void changeUserDetails(String name, String pass) {
		candidatemodel.changeUserDetails(name, pass);
	}

	@Override
	public void createResume(String name, String qualification, int yOP, String skill, long number, String mail) {
		Resume resume = new Resume(name , qualification , yOP , skill , number , mail);
		candidatemodel.createResume(resume);
	}
}
