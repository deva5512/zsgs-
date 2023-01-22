package StackAndQueue;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class InterviewProcess {
	static Random rand = new Random();
	static Scanner s = new Scanner(System.in);
	static ArrayList<Candidates> total = new ArrayList<>();
	private static Queue<Candidates> inWaitingHall = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		// The count of candidates is decided by user
		System.out.println("Enter number of candidates (1 - 50) : ");
		int count = s.nextInt();

		// If the count is greater then 50 the count is set to be 50
		if (count > 50) {
			count = 50;
		}

		// Based on the count the candidates will be added in the Array list
		for (int i = 1; i <= count; i++) {
			total.add(new Candidates(i));
		}

		// The waiting hall capacity is decided by the user
		System.out.println("Enter the waiting hall capacity : ");
		int waiting_hall_capacity = s.nextInt();

		// Candidates added inside the waiting hall randomly based on the capacity
		if (waiting_hall_capacity > total.size()) {
			throw new ImproperWaitingHallException();
		}
		addCandidate(waiting_hall_capacity);

		Candidates current_candidate = null;
		main: while (!inWaitingHall.isEmpty()) {
			// Based on the input produced by the Interviewer call the process will happen
			switch (Interviewer()) {

			// Case 1 to call a candidate
			case 1: {
				current_candidate = inWaitingHall.poll();
				addCandidate(1);
				break;
			}

			// Case 2 to know the details of the called candidate
			case 2: {
				if (current_candidate == null)
					System.out.println("Call a candidate to know the details ");
				else
					System.out.println(current_candidate);
				break;
			}

			// Case 3 To print the candidates details who are waiting in the waiting hall
			case 3: {
				int i = 1;
				for (Candidates c : inWaitingHall) {
					System.out.println("--->  Candidate " + i++);
					System.out.println(c);
				}
				break;
			}

			// Case 4 To print how many candidates are waiting outside the waiting hall
			case 4: {
				System.out.println("Total number of candidates waiting outside : " + total.size());
				break;
			}

			// Case 5 To end the interview
			case 5:
				break main;
			}
		}
		if (inWaitingHall.isEmpty()) {
			System.out.println("\n\tInterview over");
		} else {
			System.out.println("\n\tWe got the required candidates\n\t\t  Thanks You");
		}
	}

	public static int Interviewer() {
		System.out.println(
				"1) call a candidate\n2) Candidate Details\n3) Waiting hall details\n4) No of candidates waiting outside\n5) End Interview \n\nSelect an input to proceed : ");
		int input = 0;

		try {
			input = s.nextInt();
			if (input < 1 || input > 5) {
				throw new InputMismatchException();
			}
		} catch (InputMismatchException e) {
			System.out.println("Miss match input ");
			return 5;
		}

		return input;
	}

	// Function used to add candidates inside the waiting hall
	// If no one is waiting outside Nothing will be added
	public static void addCandidate(int num) {
		if (total.isEmpty()) {
			return;
		}
		for (int i = 0; i < num; i++) {
			int index = rand.nextInt(total.size());
			inWaitingHall.add(total.get(index));
			total.remove(index);
		}
	}

}
