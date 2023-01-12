package Z_sums;

public class C_62 {
	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.print("Even : ");
		for (int i : a) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.print("\nOdd : ");
		for (int i : a) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
	}
}
