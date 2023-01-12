package Z_sums;

public class A_64 { // 64.Java Program to copy all elements of one array into another array

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int b[] = new int[a.length];
		copy(a, b);
		print(a);
		print(b);

	}

	public static void copy(int[] Original, int[] Copy) {
		for (int i = 0; i < Copy.length; i++) {
			Copy[i] = Original[i];
		}
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
