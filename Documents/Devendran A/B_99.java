package Z_sums;

public class B_99 {
	public static void main(String[] args) {
		System.out.println("Enter the String : ");
		String s = A_1methods.s.next();
		System.out.println(con(s));
	}

	private static String con(String s) {
		StringBuffer b = new StringBuffer(s);
		char temp = ' ';
		for (int i = 0; i < s.length(); i++) {
			if (b.charAt(i) >= 'a' && b.charAt(i) <= 'z') {
				temp = b.charAt(i);
				temp = (char) (temp - 32);
				b.deleteCharAt(i);
				b.insert(i, temp);
			}
		}
		return b.toString();
	}
}
