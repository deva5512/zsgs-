package Z_sums;

public class A_68 { // 68.Java Program to print the sum of all the items of the array

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int res = add(a);
		System.out.println("Sum of array is : " + res);
	}

	public static int add(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}
