package hrprocess;

import java.time.LocalDate;

import com.recrutmentmanagement.dto.Hr;

public interface HrModelCallBack {

	void saveHr(Object obj);

	void mofidydetails(String name, String pass, String org);

	void addPost(String qualification, String role, LocalDate now, double price);

	double getPriceOfPost();

	Hr getcurrentHr();

	void showCandidates();

}
