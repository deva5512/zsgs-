package zohosums;

public class Nine_9 {
	public static void main(String[] args) {
		int a1[] = { 2, 4, 5, 6, 7, 9, 10, 13 };
		int a2[] = { 2, 3, 4, 5, 6, 7, 8, 9, 11, 15 };

		int res[] = new int[a1.length + a2.length];
		for (int i = 0, m = 0; i < res.length; i++) {
			if (i < a1.length) {
				res[i] = a1[i];
			} else
				res[i] = a2[m++];
		}

		for (int i = 0; i < res.length; i++) {
			for (int j = i + 1; j < res.length - 1; j++) {
				if (res[i] == res[j]) {
					res[j] = 0;
				}
			}
		}
		sort(res);
		print(res);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				System.out.print(a[i] + " ");
			}
		}
	}

	public static void sort(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
