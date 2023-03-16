package hrprocess;

import java.time.LocalDate;
import java.util.List;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

import repository.RecrutmentDb;

public class HrModel {

	public HrModel() {
	}

	private Hr hr;

	public void saveHr(Object obj) {
		this.hr = (Hr) obj;
	}

	public void mofidydetails(String name, String pass, String org) {
		if (name != null) {
			hr.setName(name);
		} else if (pass != null) {
			hr.setPassword(pass);
		} else {
			hr.setCompany_name(org);
		}

	}

	public void addPost(String qualification, String role, double price) {
		Post post = new Post(qualification, role, LocalDate.now(), this.hr, price);

		RecrutmentDb.getInstance().getPost().add(post);
		hr.getPosted().add(post);
		RecrutmentDb.getInstance().getAdmin().getNotification().offer(hr.getName() + " Has Added a post");
	}

	public double getPriceOfPost() {
		return RecrutmentDb.getInstance().getAdmin().getPostprice();
	}

	public Hr getcurrentHr() {
		return hr;
	}

	public List<Candidate> showCandidates() {
		return RecrutmentDb.getInstance().getCandidates();
	}

}
