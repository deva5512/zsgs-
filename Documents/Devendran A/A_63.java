package Z_sums;

public class A_63 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 6, 9, 8, 7, 5, 1, 0, 12 };
		System.out.println("Largest : " + largest(a));
		System.out.println("Smallest : " + smallest(a));
	}

	public static int largest(int[] a) {
		int largest = a[0];
		for (int i = 0; i < a.length; i++) {
			if (largest < a[i]) {
				largest = a[i];
			}
		}
		return largest;
	}

	public static int smallest(int[] a) {
		int small = a[0];
		for (int i = 0; i < a.length; i++) {
			if (small > a[i]) {
				small = a[i];
			}
		}
		return small;
	}
}
