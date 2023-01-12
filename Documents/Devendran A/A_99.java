package Z_sums;

public class A_99 { // 99.Java Program to convert all small letter to capital letter without using
					// special functions.

	public static void main(String[] args) {
		System.out.println("Enter the String : ");
		String s = A_1methods.s.next();
		System.out.println(con(s));

	}

	public static String con(String s) {
		StringBuffer b = new StringBuffer(s);
		String rep = "";
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) >= 'a' && b.charAt(i) <= 'z') {
				rep += b.charAt(i);
				rep = rep.toUpperCase();
				b.replace(i, i + 1, rep);
				rep = "";
			}
		}
		return new String(b);
	}
}
