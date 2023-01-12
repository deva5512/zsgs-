package Z_sums;

public class B_65 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1 };
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count > 0 && a[i] != 0) {
				System.out.println(a[i] + "  " + count);
				count = 0;
				linear(a, a[i]);
			}
		}

	}

	public static void linear(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				a[i] = 0;
			}
		}
	}
}
