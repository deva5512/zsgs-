package Z_sums;

public class B_95 {
	public static void main(String[] args) {
		System.out.print("Enter the first String : ");
		String one = A_1methods.s.next();
		System.out.print("Enter the second String : ");
		String two = A_1methods.s.next();
		if (palin(one, two)) {
			System.out.println("Yes its palindrome ");
		} else {
			System.out.println("Its not ");
		}
	}

	private static boolean palin(String one, String two) {
		if (one.length() != two.length()) {
			return false;
		}
		for (int i = 0, j = two.length() - 1; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
}
