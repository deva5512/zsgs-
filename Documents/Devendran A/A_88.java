package Z_sums;

import java.util.Arrays;

public class A_88 { // 88.Java Program to convert a sentence/paragraph to word(String) array with
					// using string function.

	public static void main(String[] args) {
		String para = A_1methods.s.nextLine();
		String[] words = para.split(" ");
		System.out.println(Arrays.toString(words));
	}

}
