package Z_sums;

import java.util.Arrays;

public class C_77 {
	public static void main(String[] args) {
		int[] a = { 8, 5, 2, 1, 4, 6, 7, 3, 9, 1 };
		System.out.println(Arrays.toString(a));
		mergSort(a);
		System.out.println(Arrays.toString(a));

	}

	private static void mergSort(int[] a) {
		int len = a.length;
		if (len == 1) {
			return;
		}
		int mid = len / 2;
		int left[] = new int[mid];
		int right[] = new int[len - left.length];

		for (int lef = 0, rig = 0; lef < a.length; lef++) {
			if (lef < mid) {
				left[lef] = a[lef];
			} else {
				right[rig++] = a[lef];
			}
		}

		mergSort(left);
		mergSort(right);
		merg(left, right, a);
	}

	private static void merg(int[] left, int[] right, int[] a) {

		int l = 0, r = 0, i = 0;

		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				a[i++] = left[l++];
			} else {
				a[i++] = right[r++];
			}
		}
		while (l < left.length) {
			a[i++] = left[l++];
		}

		while (r < right.length) {
			a[i++] = right[r++];
		}
	}
}
