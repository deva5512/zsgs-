package Z_sums;

import java.util.Arrays;
import java.util.Scanner;

public class C_70 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[] a = { 7, 8, 9, 6, 5, 2, 3, 1, 4, 0 };
		System.out.println("Enter the number : ");
		int num = s.nextInt();
		Arrays.sort(a);
		System.out.println(num+" largest in the array is : "+ a[a.length-num]);
	}

}
