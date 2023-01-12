package Z_sums;

public class A_95 { // 95.Java Program to find the given two strings are palindrome.
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

	public static boolean palin(String a, String b) {
		char[] c = a.toCharArray();
		char[] c1 = b.toCharArray();
		if (c.length != c1.length) {
			return false;
		}
		for (int i = 0, j = c1.length - 1; i < c1.length; i++) {
			if (c[i] != c1[j--]) {
				return false;
			}
		}

		return true;
	}
}
