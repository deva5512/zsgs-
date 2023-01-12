package Z_sums;

import java.util.Arrays;

public class C_75 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 9, 7, 4, 5, 6, 8, 3, 4, 8, 2, 6, 4, 8, 1, 2, 6, 4, 8 };
		System.out.print("Even numbers : ");
		Arrays.stream(a).filter(num -> num % 2 == 0).forEach(num -> System.out.print(num + " "));
		System.out.print("\nOdd numbers : ");
		Arrays.stream(a).filter(num -> num % 2 == 1).forEach(num -> System.out.print(num + " "));
	}
}
