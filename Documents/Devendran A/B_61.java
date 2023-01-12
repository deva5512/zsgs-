package Z_sums;

public class B_61 {
	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int val = a.length - 1;
		print(a, val);
	}

	public static void print(int[] a, int val) {
		if (val >= 0) {
			System.out.print(a[val--] + " ");
			print(a, val);
		}
		return;
	}

}
