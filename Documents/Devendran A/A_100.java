package Z_sums;

public class A_100 { // 100. Java Program to convert ASCHII value to character(for A-Z only) without
						// using special function
	public static void main(String[] args) {
		capitalAanci();
		System.out.println("\n********************************************");
		ca();
	}

	public static void capitalAanci() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println("Aschii value of " + (int) c + " is " + c);
		}
	}

	public static void ca() {
		for (int i = 0; i < 26; i++) {
			System.out.println("ASCHII value of " + (i + 65) + " is " + (char) (i + 65));
		}
	}
}
