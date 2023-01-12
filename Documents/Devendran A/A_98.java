package Z_sums;

public class A_98 { // 98.Java Program to print the equivalent Capital letter of a given
					// small letter in Alphabets.

	public static void main(String[] args) {
		System.out.println("Enter a String : ");
		String word = A_1methods.s.next();
		String res = repl(word);
		System.out.println(res);

	}

	public static String repl(String s) {
		char c[] = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= 'a' && c[i] <= 'z') {
				c[i] -= 32;
			}
		}
		return A_1methods.charArrayToString(c);
	}
}
