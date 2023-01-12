package Z_sums;

public class A_91 { // 91.Java Program to sort the characters in a word in descending.

	public static void main(String[] args) {
		System.out.print("Enter the String : ");
		String word = A_1methods.s.next();
		String res = des(word.toCharArray());
		System.out.println(res);

	}

	public static String des(char[] a) {
		char temp = ' ';
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] < a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return A_1methods.charArrayToString(a);
	}

}
