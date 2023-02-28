package hrprocess;

import java.time.LocalDate;

import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

import repository.RecrutmentDb;

public class HrModel implements HrModelCallBack {

	public HrModel(HrModelControllerCall hrcontroller) {
		this.hrcontroller = hrcontroller;
	}

	private HrModelControllerCall hrcontroller;

	private Hr hr;

	@Override
	public void saveHr(Object obj) {
		this.hr = (Hr) obj;
	}

	@Override
	public void mofidydetails(String name, String pass, String org) {
		if (name != null) {
			hr.setName(name);
		} else if (pass != null) {
			hr.setPassword(pass);
		} else {
			hr.setCompany_name(org);
		}

	}

	@Override
	public void addPost(String qualification, String role, LocalDate now, double price) {
		Post post = new Post(qualification, role, now, this.hr, price);

		RecrutmentDb.getInstance().getPost().add(post);
		hr.getPosted().add(post);
		RecrutmentDb.getInstance().getAdmin().getNotification().offer(hr.getName() + " Has Added a post");
	}

	@Override
	public double getPriceOfPost() {
		return RecrutmentDb.getInstance().getAdmin().getPostprice();
	}

	@Override
	public Hr getcurrentHr() {
		return hr;
	}

	@Override
	public void showCandidates() {
		hrcontroller.availableCandidates(RecrutmentDb.getInstance().getCandidates());
	}

}
