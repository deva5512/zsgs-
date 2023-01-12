package Z_sums;

public class B_67 {
	static int count = 0;

	public static void main(String[] args) {
		int[] a = { 1, 5, 9, 8, 2, 6, 5, 6, 6, 23, 2, 5, 6, 3, 1, 5, 3, 3, 2, 2, 6, 12, 3, 5, 3, 2, 1, 23, 25, 36, 2 };
		i(a, 0);

	}

	public static void i(int[] a, int i) {
		if (i < a.length) {
			count = 0;
			if (a[i] != 0) {
				j(a, i + 1, a[i]);
				if (count > 0) {
					System.out.println(a[i] + " has " + count + " duplicate");
				}
			}
			i(a, ++i);
		}
	}

	public static void j(int i[], int j, int k) {
		if (j < i.length) {
			if (k == i[j]) {
				count++;
				i[j] = 0;
			}
			j(i, ++j, k);
		}
	}
}
