package candidateprocess;

import java.util.List;

import com.recrutmentmanagement.dto.Post;

public interface CandidateViewCallBack {

	void candidateUpdateResume(String error);

	void viewJobs(List<Post> list);

}
