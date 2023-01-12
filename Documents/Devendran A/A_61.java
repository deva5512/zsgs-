package Z_sums;

public class A_61 {
	public static void main(String[] args) {
		int a[] = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		print(a);
	}

	public static void print(int a[]) {
		for (int j = a.length - 1; j >= 0; j--) {
			System.out.print(a[j] + " ");
		}
	}
}
