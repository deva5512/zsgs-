package Z_sums;

public class A_93 { // 93.Java Program to sort the characters in a word in descending using
					// recursion.

	public static void main(String[] args) {
		System.out.println("Enter a String : ");
		String word = A_1methods.s.next();
		char[] a = word.toCharArray();
		rep(a, 0);
		System.out.println(A_1methods.charArrayToString(a));

	}

	public static void decRec(char[] a, int j) {
		if (j < a.length - 1) {
			if (a[j] < a[j + 1]) {
				char temp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = temp;
			}
			decRec(a, ++j);
		}
	}

	public static void rep(char[] a, int i) {
		if (i < a.length) {
			decRec(a, 0);
			rep(a, ++i);
		}
	}

}
