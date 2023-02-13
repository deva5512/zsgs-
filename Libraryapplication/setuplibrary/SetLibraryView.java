package com.library.setuplibrary;

import java.util.Scanner;

public class SetLibraryView {

	private Scanner scanner = new Scanner(System.in);
	private SetLibraryControler setLibraryControler;

	public SetLibraryView() {
		setLibraryControler = new SetLibraryControler(this);
	}

	public static void main(String[] args) {
		SetLibraryView setLibraryView = new SetLibraryView();
		setLibraryView.verification();
	}

	private void verification() {
		System.out.println(" -> Book Management <- \n");
		System.out.print("Enter the user name : ");
		String user_name = scanner.nextLine();
		System.out.print("\nEnter the password : ");
		String password = scanner.nextLine();
		setLibraryControler.verification(user_name, password);
	}

	public void adminVerified() {
		System.out.println("\n ->  Admin Verified <- ");
		System.out.println("\n1)Set details \n2)View details ");
		System.out.print("\nSelect the input : ");
		int input = scanner.nextInt();
		scanner.nextLine();
		if (input == 1) {
			setLibraryDetails();
		} else if (input == 2) {
			viewLibraryDetails();
		} else {
			System.out.println("Wrong input ");
		}
	}

	public void verificationFailed(String error) {
		System.out.print("\n" + error + "\n");
		verification();
	}

	private void setLibraryDetails() {
		System.out.print("Enter the name of the library : ");
		String library_name = scanner.nextLine();
		System.out.print("Enter the address of the library : ");
		String library_address = scanner.nextLine();
		setLibraryControler.setLibraryDetails(library_name, library_address);
	}

	private void viewLibraryDetails() {
		String library_name = setLibraryControler.viewLibraryName();
		String library_address = setLibraryControler.viewLibraryAddress();
		if (library_name != null) {
			System.out.println("\nLibrary Name : " + library_name);
			System.out.println("Library Address : " + library_address);
		} else {
			System.out.println("\nFirst set the details to view it ");
			setLibraryDetails();
		}
	}
}
