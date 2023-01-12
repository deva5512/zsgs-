package Z_sums;

import java.util.Arrays;

public class B_72 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 3, 1, 4, 6, 2, 3, 1, 5, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);

		int res[] = new int[a.length];
		int count = 0;

		for (int i = 0; i < res.length; i++) {
			if (i == 0 || a[i] != a[i - 1]) {
				res[count++] = a[i];
			}
		}
		System.out.println(Arrays.toString(a));
		res = Arrays.copyOf(res, count);
		System.out.println(Arrays.toString(res));
	}
}
