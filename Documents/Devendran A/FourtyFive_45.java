package zohosums;

public class FourtyFive_45 {
	static int[] a = { 1, 2, 3, 4, 5, 2, 1, 2, 6, 3, 8, 4 };

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println("sum of the given array is : " + sum);
	}
}
