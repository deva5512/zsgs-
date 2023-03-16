package repository;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

public class RecrutmentDb {

	private static RecrutmentDb recrutmentDb;

	private List<Hr> hrlist = new LinkedList<>();

	private List<Candidate> candidates = new LinkedList<>();

	private List<Post> post = new LinkedList<>();

	Admin admin;

	private RecrutmentDb() {
		admin = new Admin("admin", "123", 12334567890l);
	}

	public boolean containsCandidate(String name, String pass) {
		if (candidates == null) {
			return false;
		}
		Iterator<Candidate> it = candidates.iterator();
		while (it.hasNext()) {
			Candidate candidate = it.next();
			if (candidate.getName().equalsIgnoreCase(name.trim())
					&& candidate.getPassword().equalsIgnoreCase(pass.trim())) {
				return true;
			}
		}
		return false;
	}

	public boolean containsHr(String name, String pass) {
		if (hrlist == null) {
			return false;
		}
		Iterator<Hr> it = hrlist.iterator();
		while (it.hasNext()) {
			Hr hr = it.next();
			if (hr.getName().equalsIgnoreCase(name.trim()) && hr.getPassword().equalsIgnoreCase(pass.trim())) {
				return true;
			}
		}
		return false;
	}

	public static RecrutmentDb getRecrutmentDb() {
		return recrutmentDb;
	}

	public List<Hr> getHrlist() {
		return hrlist;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public List<Post> getPost() {
		return post;
	}

	public Admin getAdmin() {
		return admin;
	}

	public static void setRecrutmentDb(RecrutmentDb recrutmentDb) {
		RecrutmentDb.recrutmentDb = recrutmentDb;
	}

	public void setHrlist(List<Hr> hrlist) {
		this.hrlist = hrlist;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public static RecrutmentDb getInstance() {
		if (recrutmentDb == null) {
			recrutmentDb = new RecrutmentDb();
		}
		return recrutmentDb;
	}

	public Candidate getValidCandidate(String name, String pass) {
		Iterator<Candidate> it = candidates.iterator();
		while (it.hasNext()) {
			Candidate candidate = it.next();
			if (candidate.getName().equalsIgnoreCase(name.trim())
					&& candidate.getPassword().equalsIgnoreCase(pass.trim())) {
				return candidate;
			}
		}
		return null;
	}

	public Hr getValidHr(String name, String pass) {
		Iterator<Hr> it = hrlist.iterator();
		while (it.hasNext()) {
			Hr hr = it.next();
			if (hr.getName().equalsIgnoreCase(name.trim()) && hr.getPassword().equalsIgnoreCase(pass.trim())) {
				return hr;
			}
		}
		return null;
	}

}
