package Z_sums;

public class C_65 {
	static int count = 1;

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 5, 5, 1, 1, 2 };
		i(a, 0);
	}

	public static void i(int[] a, int i) {
		if (i < a.length) {
			if (a[i] != 0) {
				j(a, a[i], i + 1);
				System.out.println(a[i] + "  " + count);
				count = 1;
			}
			i(a, ++i);
		}
	}

	public static void j(int[] a, int k, int j) {
		if (j < a.length) {
			if (k == a[j]) {
				a[j] = 0;
				count++;
			}
			j(a, k, ++j);
		}
	}
}
