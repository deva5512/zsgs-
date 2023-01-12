package zohosums;

public class ThirtyEight_38 {
	public static void main(String[] args) {
		int[] a = { 1, 7, 8, 9, 2, 3, 5 ,15 };

		int largest = a[0];
		for (int i = 0; i < a.length; i++) {
			if (largest < a[i]) {
				largest = a[i];
			}
		}
		System.out.println("The largest element in the array is : " + largest);
	}
}
