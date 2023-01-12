package Z_sums;

public class B_94 {
	public static void main(String[] args) {
		System.out.print("Enter the first String : ");
		String one = A_1methods.s.next();
		System.out.print("Enter the second String : ");
		String two = A_1methods.s.next();
		if (anagram(one, two)) {
			System.out.println("Yes the string is anagram to each other");
		} else {
			System.out.println("No");
		}
	}

	private static boolean anagram(String one, String two) {
		one = stringSorter(one);
		two = stringSorter(two);
		if (one.length() != two.length()) {
			return false;
		}
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static String stringSorter(String a) {
		StringBuffer s = new StringBuffer(a);
		char c = ' ';
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = 0; j < s.length() - 1; j++) {
				if (s.charAt(j) > s.charAt(j + 1)) {
					c = s.charAt(j);
					s.deleteCharAt(j);
					s.insert(j + 1, c);
				}
			}
		}
		return new String(s);
	}

}
