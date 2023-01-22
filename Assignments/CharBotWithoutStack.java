package StackAndQueue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CharBotWithoutStack {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		total: while (true) {
			int input = start();
			switch (input) {
			case 1: {
				inner: while (true) {
					switch (newUserActivation()) {
					case 1: {
						if (verification(1) == 1)
							break inner;
						break;
					}
					case 2: {
						if (verification(2) == 1)
							break inner;
						break;
					}
					case 3:
						break inner;
					case 4:
						break total;
					}
				}
				break;
			}
			case 2: {
				if (offersAndPlans() == 2)
					break total;
				break;
			}
			case 3: {
				if (currentPlan() == 2)
					break total;
				break;
			}
			case 4:
				break total;
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
			System.out.println("Mis Match input");
			return 4;
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
			System.out.println("Mis Match input");
			return 4;
		}
		return num;
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
			System.out.println("Mis Match input");
			return 1;
		}
		return num;

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
			System.out.println("Mis Match input");
			return 2;
		}
		return num;
	}

	private static int currentPlan() {
		System.out.println("\n\n\t-> your current plan Expires on 05/04/2023");
		System.out.println("\t-> Remaining data 2.23 Gb");
		System.out.println("\t-> Unlimited calls ");
		System.out.println("\nTo go back main menu press 1 \n");
		int num = 0;
		try {
			num = s.nextInt();
			if (num == 1)
				return 1;
			throw new InputMismatchException();
		} catch (InputMismatchException e) {
			System.out.println("Mis Match input");
		}
		return 2;
	}

}
