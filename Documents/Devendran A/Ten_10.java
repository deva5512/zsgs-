package zohosums;

public class Ten_10 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0, m = a.length - 1, n = 0; i < a.length; i++) {
			if (i % 2 != 0) {
				System.out.print(a[n++] + " ");
			} else {
				System.out.print(a[m--] + " ");
			}
		}
	}
}
