package Z_sums;

public class A_96 { // 96.Java program to find a character in a word string linear search.
	public static void main(String[] args) {
		System.out.println("Enter the String : ");
		String s = A_1methods.s.next();
		System.out.println("Enter the charactor : ");
		char c = A_1methods.s.next().charAt(0);
		if (ls(s, c)) {
			System.out.println("Yes the charactor is present in the String ");
		} else {
			System.out.println("Its not present ");
		}
	}

	public static boolean ls(String s, char key) {
		for (int i = 0; i < s.length(); i++) {
			if (key == s.charAt(i)) {
				return true;
			}
		}
		return false;
	}

}
