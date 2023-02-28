package candidateprocess;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.GetInput;
import com.recrutmentmanagement.dto.Post;
import com.recrutmentmanagement.dto.Resume;
import com.recrutmentmanagement.dto.Teleportable;

public class CandidateView implements CandidateViewCallBack, Teleportable {

	private CandidateViewControllerCall candidatecontroller;
	private Scanner scanner = new Scanner(System.in);

	public CandidateView() {
		this.candidatecontroller = new CandidateController(this);
	}

	@Override
	public void caller(Object obj) {

		candidatecontroller.saveCandidate(obj);

		Queue<String> notification = ((Candidate) obj).getNotification();

		while (true) {

			if (!notification.isEmpty()) {
				System.out.println("\nYou have " + notification.size() + " new notification ");
			}

			System.out.println(
					"\n1)View Notification \n2)View Jobs \n3)Create Resume \n4)View Candidate Details \n5)Modify Candidate Details\n6)View Resume \n7)Go Back ");
			int input = GetInput.getInt();

			if (input == 1) {
				viewNotification(notification);
			} else if (input == 2) {
				candidatecontroller.getResumeStatus();
			} else if (input == 3) {
				resume();
			} else if (input == 4) {
				Candidate candidate = (Candidate) obj;

				System.out.println("\nCandidate Name : " + candidate.getName());
				System.out.println("Candidate pass : " + candidate.getPassword());
			} else if (input == 5) {
				modifyCandidateDetails();
			} else if (input == 6) {
				viewResume(obj);
			} else if (input == 7) {
				break;
			} else {
				System.out.println("Improper input ");
			}
		}

	}

	private void viewResume(Object obj) {
		Resume resume = ((Candidate) obj).getResume();

		if (resume == null) {
			System.out.println("No resume has been uploded ");
		} else {
			System.out.println(resume);
		}
	}

	private void viewNotification(Queue<String> notification) {
		if (notification.isEmpty()) {
			System.out.println("\nNo notification is available right now ! ");
			return;
		}

		int num = 1;

		System.out.println("\n -> Notification <- \n");

		while (!notification.isEmpty()) {
			System.out.println(num++ + ") " + notification.poll());
		}
		System.out.println();
	}

	private void modifyCandidateDetails() {
		System.out.println("\n -> Modify Candidate Details <- ");

		System.out.println("\n1)Modify Name \n2)Modify Password \n3)GoBack");
		int input = GetInput.getInt();

		if (input == 1) {
			System.out.print("\nEnter your new Name : ");
			String name = scanner.nextLine();

			candidatecontroller.changeUserDetails(name, null);

			System.out.println("\nName changed Successfully ");

		} else if (input == 2) {

			System.out.print("\nEnter your new Password : ");
			String pass = scanner.nextLine();

			candidatecontroller.changeUserDetails(null, pass);
			System.out.println("\nPassword changed Successfully ");

		} else if (input != 3) {
			System.out.println("Improper input ");
		}

	}

	private void resume() {

		System.out.println("\n -> Resume <-");

		System.out.print("\nEnter your name : ");
		String name = scanner.nextLine();

		System.out.print("\nEnter your Qualification : ");
		String qualification = scanner.nextLine();

		int YOP = GetInput.getInt("YOP");

		System.out.print("\nEnter your Skills : ");
		String skill = scanner.nextLine();

		long number = GetInput.getMobile();

		String mail = GetInput.getEmail();

		candidatecontroller.createResume(name, qualification, YOP, skill, number, mail);
		System.out.println("Resume Created Successfully ");

	}

	@Override
	public void candidateUpdateResume(String error) {
		System.out.println("\n" + error);
	}

	@Override
	public void viewJobs(List<Post> list) {

		if (list.isEmpty()) {
			System.out.println("\nCurrently no jobs has been posted ");
			return;
		}

		Iterator<Post> it = list.iterator();

		while (it.hasNext()) {
			Post post = it.next();

			post.setViews(post.getViews() + 1);

			System.out.println("+----------------------------------------+");
			System.out.printf("| %-15s : %-20s |\n", "Hr Name", post.getHr().getName());
			System.out.printf("| %-15s : %-20s |\n", "Role", post.getRole());
			System.out.printf("| %-15s : %-20s |\n", "Qualification", post.getQualification());
			System.out.printf("| %-15s : %-20s |\n", "Posted Date", post.getDateofpost());
			System.out.println("+----------------------------------------+");
			System.out.printf("| %-29s  %-7s |\n", "1)Apply", "2)Next");
			System.out.println("+----------------------------------------+");

			int input = GetInput.getInt();

			if (input == 1) {
				Candidate candidate = candidatecontroller.getCandidate();
				post.getApplied().add(candidate);
				System.out.println("\nApplied Successfully ");

				post.getHr().getNotification()
						.offer(candidate.getName() + " has applied to your post of role" + post.getRole());

			} else if (input != 2) {
				System.out.println("\nInproper input ");
			}

		}
	}

}
