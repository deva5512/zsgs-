package hrprocess;

import java.util.List;

import com.recrutmentmanagement.dto.Candidate;

public interface HrViewCallBack {

	void availableCandidates(List<Candidate> candidates);

}
