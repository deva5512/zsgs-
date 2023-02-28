package hrprocess;

import java.time.LocalDate;
import java.util.List;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;

public class HrConroller implements HrViewControllerCall, HrModelControllerCall {

	public HrConroller(HrViewCallBack hrview) {
		this.hrview = hrview;
		this.hrmodel = new HrModel(this);
	}

	private HrViewCallBack hrview;
	private HrModelCallBack hrmodel;

	@Override
	public void saveHr(Object obj) {
		hrmodel.saveHr(obj);
	}

	@Override
	public void mofidydetails(String name, String pass, String org) {
		hrmodel.mofidydetails(name, pass, org);
	}

	@Override
	public void addPost(String qualification, String role, double price) {

		hrmodel.addPost(qualification, role, LocalDate.now(), price);
	}

	@Override
	public double getPriceOfPost() {
		return hrmodel.getPriceOfPost();
	}

	@Override
	public Hr getcurrentHr() {
		return hrmodel.getcurrentHr();
	}

	@Override
	public void showCandidates() {
		hrmodel.showCandidates();
	}

	@Override
	public void availableCandidates(List<Candidate> candidates) {
		hrview.availableCandidates(candidates);
	}
}
