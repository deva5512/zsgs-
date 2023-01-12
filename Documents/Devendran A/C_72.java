package Z_sums;

import java.util.Arrays;

public class C_72 { // 72.Java Program to remove Duplicate Element in an Array

	public static void main(String[] args) {
		int[] a = { 5, 1, 2, 3, 5, 4, 6, 1, 2, 3, 1, 2, 5, 4, 1, 2, 3, 1, 2, 5, 3, 1, 4, 2, 2 };
		System.out.println(Arrays.toString(a));
		int res[] = new int[a.length];
		int v = 0;
		i(a, v);
		for (int i : a) {
			if (i != 0) {
				res[v++] = i;
			}
		}
		res = Arrays.copyOf(res, v);
		System.out.println(Arrays.toString(res));
	}

	public static void i(int[] a, int i) {
		if (i < a.length) {
			remover(a, a[i], i + 1);
			i(a, ++i);
		}
	}

	public static void remover(int[] i, int key, int j) {
		if (j < i.length) {
			if (key == i[j]) {
				i[j] = 0;
			}
			remover(i, key, ++j);
		}
	}
}
