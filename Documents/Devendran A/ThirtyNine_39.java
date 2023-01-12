package zohosums;

public class ThirtyNine_39 {
	public static void main(String[] args) {
		int[] a = { 1, 7, 8, 9, 2, 3, 5 ,15 , -5};

		int smallest = a[0];
		for (int i = 0; i < a.length; i++) {
			if (smallest > a[i]) {
				smallest = a[i];
			}
		}
		System.out.println("The smallest element in the array is : " + smallest);
	}
}
