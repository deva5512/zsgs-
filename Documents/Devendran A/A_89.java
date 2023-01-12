package Z_sums;

import java.util.Arrays;

public class A_89 { // 89.Java Program to convert a sentence/paragraph to word(String) array without
					// using string function.
	public static void main(String[] args) {
		System.out.println("Enter any para for the string : ");
		String para = A_1methods.s.nextLine();
		String para1 = "how many times do i want to   .     tell you dont sleep until finish the task    do you understand.";
		para1+= " ";
		String res[] = seperator(para1);
		System.out.println(Arrays.toString(res));
		for (String i : res) {
			System.out.print(i + " ");
		}
	}

	public static String[] seperator(String s) {
		String[] res = new String[s.length()];
		int count = 0;
		String word = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				word += s.charAt(i);
			} else if (i != 0 && s.charAt(i - 1) != ' ') {
				res[count++] = word;
				word = "";
			}
		}
		return Arrays.copyOf(res, count);
	}
}
