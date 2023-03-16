package dto;

import java.util.Scanner;

public class GetInput {

	private static Scanner scanner = new Scanner(System.in);

	public static int getInt(String... s) {
		String input = "input";
		if (s.length > 0) {
			input = s[0];
		}
		int num = 0;
		while (true) {
			System.out.print("\nEnter the " + input + " : ");

			try {
				num = scanner.nextInt();
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("\nInvalid input ");
			}

		}
		return num;
	}

	public static double getDouble(String... s) {
		String input = "amount";
		if (s.length > 0) {
			input = s[0];
		}
		double num = 0;
		while (true) {
			System.out.print("\nEnter the " + input + " : ");

			try {
				num = scanner.nextDouble();
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("\nInvalid input ");
			}

		}
		return num;
	}

}
