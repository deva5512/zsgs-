package hrprocess;

import com.recrutmentmanagement.dto.Hr;

public interface HrViewControllerCall {

	void saveHr(Object obj);

	void mofidydetails(String name, String pass, String org);

	void addPost(String qualification, String role, double price);

	double getPriceOfPost();

	Hr getcurrentHr();

	void showCandidates();

}
