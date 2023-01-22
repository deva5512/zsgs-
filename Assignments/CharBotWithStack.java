package StackAndQueue;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class CharBotWithStack {
	static Scanner s = new Scanner(System.in);
	static Stack<Integer> inputs = new Stack<>();

	public static void main(String[] args) {
		int res = 0;
		inputs.add(res);
		while (!inputs.isEmpty()) {
			switch (inputs.peek()) {
			case 0: {
				res = start();
				inputs.push(res);
				break;
			}
			case 1: {
				res = newUserActivation();
				inputs.push(res);
				break;
			}
			case 2: {
				res = offersAndPlans();
				inputs.push(res);
				break;
			}
			case 3: {
				res = currentPlan();
				inputs.push(res);
				break;
			}
			case 4, 8: {
				inputs.clear();
				System.out.println("\n\t\tThankyou");
				System.out.println("\t   Hope See You Again");
				break;
			}
			case 5: {
				res = verification(1);
				inputs.push(res);
				break;
			}
			case 6: {
				res = verification(2);
				inputs.push(res);
				break;
			}
			case 7, 10: {
				inputs.pop();
				inputs.pop();
				break;
			}
			case 9, 11, 12: {
				inputs.clear();
				inputs.add(0);
				break;
			}
			case -1: {
				System.out.println("Mis Match input");
				inputs.clear();
			}
			}
		}
	}

	private static int start() {
		System.out.println("______Welcome to sim chat Bot______\n");
		System.out.print("1) New User activation \n2) About offers & plans \n3) About current plan \n4) Exit\n\n");
		System.out.print("Enter your input : ");
		int num = 0;
		try {
			num = s.nextInt();
			if (num < 1 || num > 4)
				throw new InputMismatchException();
			else {

			}
		} catch (InputMismatchException e) {
			return -1;
		}
		return num;
	}

	private static int newUserActivation() {
		System.out.print("\n\n1) Verify with alternate number \n2) Verify with Email \n3) Back  \n4) Exit\n\n");
		System.out.print("Enter your input : ");
		int num = 0;
		try {
			num = s.nextInt();
			if (num < 1 || num > 4)
				throw new InputMismatchException();
		} catch (InputMismatchException e) {
			return -1;
		}
		return num += 4;
	}

	private static int verification(int n) {
		if (n == 1)
			System.out.println("Enter your mobile number : ");
		else
			System.out.println("Enter your mail id : ");
		s.next();
		int gen_otp = (int) (9999 + Math.random() * 9999);
		System.out.println(gen_otp);
		System.out.print("Enter the otp to proceed : ");
		int otp = 0;
		try {
			otp = s.nextInt();
			if (gen_otp == otp)
				System.out.println("Verified successfully ");
			else
				System.out.println("Verification failed due to improper otp ");
		} catch (Exception e) {
			System.out.println("Verification failed due to improper otp ");
			s.nextLine();
		}

		System.out.println("\nTo go back main menu press 1 \nTo go back press 2");
		int num = 0;
		try {
			num = s.nextInt();
			if (num != 1 && num != 2)
				throw new InputMismatchException();
		} catch (InputMismatchException e) {
			return -1;
		}
		return num += 8;

	}

	private static int offersAndPlans() {
		System.out.print("\n-> New offer for new users 1 Month free recharge\n");
		System.out.print("-> Recharge 1 year plans for 6 months free disny hotstar\n");
		System.out.print("-> Book new sim and get free home delevry within 2 days\n");
		System.out.print("-> Recharge more then 1500 to get 10% offer \n");
		System.out.println("\nTo go back main menu press 1\n");
		int num = 0;
		try {
			num = s.nextInt();
			if (num != 1)
				throw new InputMismatchException();
		} catch (InputMismatchException e) {
			return -1;
		}
		return num += 10;
	}

	private static int currentPlan() {
		System.out.println("\n\n\t-> your current plan Expires on 05/04/2023");
		System.out.println("\t-> Remaining data 2.23 Gb");
		System.out.println("\t-> Unlimited calls ");
		System.out.println("\nTo go back main menu press 1 \n");
		int num = 0;
		try {
			num = s.nextInt();
			if (num != 1)
				throw new InputMismatchException();
		} catch (InputMismatchException e) {
			return -1;
		}
		return num += 11;
	}
}
