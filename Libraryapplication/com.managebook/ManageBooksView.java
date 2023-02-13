package com.library.managebook;

import java.util.Map;
import java.util.Scanner;

public class ManageBooksView {

	private Scanner scanner = new Scanner(System.in);
	private ManageBooksControler manageBooksControler;

	public ManageBooksView() {
		manageBooksControler = new ManageBooksControler(this);
	}

	public static void main(String[] args) {
		ManageBooksView manageBooksView = new ManageBooksView();
		manageBooksView.verifier();
	}

	private void verifier() {
		System.out.println(" -> Book Management <- \n");
		System.out.print("Enter the user name : ");
		String user_name = scanner.nextLine();
		System.out.print("\nEnter the password : ");
		String password = scanner.nextLine();
		manageBooksControler.verify(user_name, password);
	}

	public void addbook() {
		System.out.print("\nEnter Book name : ");
		String book_name = scanner.nextLine();
		System.out.print("\nEnter Book Id : ");
		int id = scanner.nextInt();
		scanner.nextLine();

		manageBooksControler.addbook(book_name, id);
	}

	public void adminVerified() {
		System.out.println("\n ->  Admin Verified <- ");
		System.out.println(" 1) Add Book \n 2) Remove Book \n 3) View Books");
		System.out.print("Enter your input : ");
		int input = scanner.nextInt();
		scanner.nextLine();
		if (input == 1) {
			addbook();
		} else if (input == 2) {
			removeBook();
		} else if (input == 3) {
			viewBook();
		} else {
			System.out.println("Wrong input ");
			adminVerified();
		}

	}

	public void verificationFailed(String error) {
		System.out.print("\n" + error + "\n");
		verifier();
	}

	public void addingFailed(String error) {
		System.out.print("\n" + error + "\n");
		addbook();
	}

	public void addedSuccessfully() {
		System.out.println("Do you want to add book further : \n\n1) yes \n2)no");
		int input = scanner.nextInt();
		scanner.nextLine();

		while (true) {
			if (input == 1) {
				addbook();
			} else if (input == 2) {
				System.out.println(" Thankyou ");
			}
			break;
		}
	}

	public void removeBook() {
		System.out.println("Enter the Book id : ");
		int id = scanner.nextInt();
		scanner.nextLine();

		manageBooksControler.removebook(id);
	}

	public void bookRemovedSuccessfully() {
		System.out.println("Do you want to remove any book further \n1) yes \n2) no");
		int input = scanner.nextInt();
		scanner.nextLine();

		while (true) {
			if (input == 1) {
				removeBook();
			} else if (input == 2) {
				System.out.println("Thank you ");
			}
			break;
		}
	}

	public void bookRemovedFailde(String error) {
		System.out.print("\n" + error + "\n");
		if (!error.equals("No book exist"))
			removeBook();
	}

	public void viewBook() {
		Map<Integer, String> books = manageBooksControler.viewBooks();
		if (books.isEmpty()) {
			System.out.println("\nNo books exist \ns");
		} else {
			for (Integer i : books.keySet()) {
				System.out.println(i + " - " + books.get(i));
			}
		}
	}

}
