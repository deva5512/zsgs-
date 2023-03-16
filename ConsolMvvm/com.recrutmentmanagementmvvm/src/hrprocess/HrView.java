package hrprocess;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.GetInput;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;
import com.recrutmentmanagement.dto.Teleportable;

public class HrView implements Teleportable {

	private HrModel hrModel;
	private Scanner scanner = new Scanner(System.in);

	public HrView() {
		this.hrModel = new HrModel();
	}

	@Override
	public void caller(Object obj) {
		hrModel.saveHr(obj);

		Queue<String> notification = ((Hr) obj).getNotification();

		while (true) {

			if (!notification.isEmpty()) {
				System.out.println("\nYou have " + notification.size() + " new notification ");
			}

			System.out.println(
					"\n1)View Notification \n2)Add Post \n3)View Post \n4)Delete post \n5)Show Candidate \n6)View Details \n7)Modify Details\n8)Go Back ");
			int input = GetInput.getInt();

			if (input == 1) {
				viewNotification(notification);
			} else if (input == 2) {
				addPost();
			} else if (input == 3) {
				viewPost();
			} else if (input == 4) {
				deletPost();
			} else if (input == 5) {
				showCandidates();
			} else if (input == 6) {
				Hr hr = (Hr) obj;

				System.out.println("\nName         : " + hr.getName());
				System.out.println("password       : " + hr.getPassword());
				System.out.println("Organization   : " + hr.getCompany_name());
			} else if (input == 7) {
				modifyHrDetails();
			} else if (input == 8) {
				break;
			} else {
				System.out.println("\nImproper input ");
			}
		}
	}

	private void deletPost() {

		Hr hr = hrModel.getcurrentHr();

		if (hr.getPosted().isEmpty()) {
			System.out.println("\nNo post has been uploded ");
			return;
		}

		ListIterator<Post> it = hr.getPosted().listIterator();

		while (it.hasNext()) {

			Post post = it.next();

			System.out.println("+----------------------------------------+");
			System.out.printf("| %-15s : %-20s |\n", "Hr Name", post.getHr().getName());
			System.out.printf("| %-15s : %-20s |\n", "Role", post.getRole());
			System.out.printf("| %-15s : %-20s |\n", "Qualification", post.getQualification());
			System.out.printf("| %-15s : %-20s |\n", "Posted Date", post.getDateofpost());
			System.out.printf("| %-15s : %-20s |\n", "Post Views", post.getViews());
			System.out.printf("| %-15s : %-20s |\n", "Applied", post.getApplied().size());
			System.out.println("+----------------------------------------+");
			System.out.printf("| %-29s  %-7s |\n", "1)Delete", "2)Next");
			System.out.println("+----------------------------------------+");

			int input = GetInput.getInt();

			if (input == 1) {
				it.previous();
				it.remove();
				System.out.println("\nDeleted Successfully ");
			}
		}
	}

	private void viewPost() {
		Hr hr = hrModel.getcurrentHr();

		if (hr.getPosted().isEmpty()) {
			System.out.println("\nNo post has been uploded ");
			return;
		}

		int num = 1;

		Iterator<Post> it = hr.getPosted().iterator();

		while (it.hasNext()) {

			Post post = it.next();

			System.out.println("+-----------------post " + num++ + "-----------------+");
			System.out.printf("| %-15s : %-20s |\n", "Hr Name", post.getHr().getName());
			System.out.printf("| %-15s : %-20s |\n", "Role", post.getRole());
			System.out.printf("| %-15s : %-20s |\n", "Qualification", post.getQualification());
			System.out.printf("| %-15s : %-20s |\n", "Posted Date", post.getDateofpost());
			System.out.printf("| %-15s : %-20s |\n", "Post Views", post.getViews());
			System.out.printf("| %-15s : %-20s |\n", "Applied", post.getApplied().size());
			System.out.println("+----------------------------------------+");

			if (!post.getApplied().isEmpty()) {
				System.out.println("\nDo you Wish to know the candidates Who are applied for this post ?");
				System.out.println("\n1)Yes 2)No");
				int input = GetInput.getInt();

				if (input == 1) {
					Iterator<Candidate> list = post.getApplied().iterator();
					while (list.hasNext())
						System.out.println(list.next().getResume());
				}
			}

		}

	}

	private void addPost() {
		System.out.print("\nEnter the Qualification you are looking for : ");
		String qualification = scanner.nextLine();

		System.out.print("\nEnter the Job role : ");
		String role = scanner.nextLine();

		double price = hrModel.getPriceOfPost();

		if (payment(price)) {
			hrModel.addPost(qualification, role, price);
			System.out.println("\nPosted Successfully ");
		} else
			System.out.println("\nPosting failed due to Transaction failed ");
	}

	private boolean payment(double price) {
		System.out.printf("\n%s : %.2f\n", "Amount to be paid", price);

		double amount = 0;

		while (true) {
			try {
				System.out.print("\nEnter the amount : ");
				amount = scanner.nextDouble();
				scanner.nextLine();
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Invalid input ");
			}
		}

		if (amount == price) {
			return true;
		} else {
			return false;
		}
	}

	private void modifyHrDetails() {
		System.out.println("\n -> Modify Details <- ");
		System.out.println("\n1)Change name \n2)Change password \n3)Change Organization name \n4)Go Back ");

		int input = GetInput.getInt();

		if (input == 1) {
			System.out.print("\nEnter your new User name : ");
			String name = scanner.nextLine();

			hrModel.mofidydetails(name, null, null);

			System.out.println("\nName changed Successfully ");

		} else if (input == 2) {

			System.out.println("\nEnter your new Password : ");
			String pass = scanner.nextLine();

			hrModel.mofidydetails(null, pass, null);

			System.out.println("\nPassword changed Successfully ");

		} else if (input == 3) {
			System.out.println("\nEnter your new Organization name : ");
			String org = scanner.nextLine();

			hrModel.mofidydetails(null, null, org);

			System.out.println("\nOrganization name changed Successfully ");

		} else if (input != 4) {
			System.out.println("\nImproper inpur ");
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

	public void showCandidates() {
		
		List<Candidate> candidates = hrModel.showCandidates();
		
		if (candidates.isEmpty()) {
			System.out.println("\nCurrently No candidates Available ");
			return;
		}

		Iterator<Candidate> it = candidates.iterator();
		Hr hr = hrModel.getcurrentHr();

		while (it.hasNext()) {

			Candidate candidate = it.next();

			System.out.print(candidate.getResume());
			System.out.printf("| %-34s  %-7s |\n", "1)Chat", "2)Next");
			System.out.println("+---------------------------------------------+");
			int input = GetInput.getInt();

			if (input == 1) {

				System.out.print("\nEnter your message : ");
				String message = scanner.nextLine();
				candidate.getNotification()
						.add(message + "\nRecieved from Hr." + hr.getName() + " of " + hr.getCompany_name());

				System.out.println("\nText Sent Successfully ");
			}

		}
	}

}
