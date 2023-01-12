package Z_sums;

public class B_75 {
	public static void main(String[] args) {
		int[] a = { 5, 9, 8, 7, 4, 1, 2, 5, 6, 2, 3, 5, 4, 1, 5, 6, 2, 2, 5, 5, 66, 3, 25, 12, 5, 6, 2, 3, 3, 5, 6, 2,
				3, 32, 3, 3 };
		System.out.print("Even numbers : ");
		for (int i : a) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.print("\nOdd numbers : ");
		for (int i : a) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
	}
}
