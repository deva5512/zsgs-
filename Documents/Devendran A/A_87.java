package Z_sums;

public class A_87 { // 87.Java Program to convert char array to string without using toString()
					// method.

	public static void main(String[] args) {
		char[] ch = { 'I', 'T', '`', 'S', ' ', 'A', ' ', 'L', 'O', 'N', 'G', ' ', 'P', 'R', 'O', 'C', 'E', 'S', 'S',
				'.' };
		String res = converter(ch);
		System.out.println(res);
	}

	public static String converter(char[] c) {
		StringBuffer b = new StringBuffer();
		for (char d : c) {
			b.append(d);
		}
		return new String(b);
	}
}
