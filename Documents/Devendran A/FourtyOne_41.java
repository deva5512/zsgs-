package zohosums;

public class FourtyOne_41 {
	public static void main(String[] args) {
		int a[] = { 1, 5, 6, 9, 8, 5, 5, 2, 2, 32, 5 };
		int b[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		print(a);
		print(b);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
