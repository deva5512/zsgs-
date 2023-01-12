package Z_sums;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A_70 { // 70.Java Program to find the 2nd Largest Number in an Array
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		System.out.println("Enter the which largest number to be found : ");
		int num;
		try {
			num = s.nextInt();
			int res = lar(a, num);
			System.out.println("The " + num + " largest is " + res);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("length of the array itself less then the value you passed in");
		} catch (InputMismatchException e) {
			System.out.println("pass a valid input to proceed ");
		}
	}

	public static int lar(int[] a, int lar) {
		int largest = 0;
		for (int t = 0; t < lar; t++) {
			largest = a[t];
			for (int i : a) {
				if (largest < i) {
					largest = i;
				}
			}
			remover(a, largest);
		}
		return largest;
	}

	public static void remover(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (key == a[i]) {
				a[i] = -1;
			}
		}
	}

}
