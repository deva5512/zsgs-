package Z_sums;

public class B_63 {
	static int l, s;

	public static void main(String[] args) {
		int[] a = { 1, 2, 5, 6, 9, 8, 7, 5, 1, 0, 12, 15, -5 };
		System.out.println("Largest : " + l(a, 0));
		System.out.println("Smallest : " + s(a, 0));
	}

	public static int l(int a[], int key) {
		if (key < a.length) {
			if (l < a[key]) {
				l = a[key];
			}
			l(a, ++key);
		}
		return l;
	}

	public static int s(int a[], int key) {
		if (key < a.length) {
			if (s > a[key]) {
				s = a[key];
			}
			s(a, ++key);
		}
		return s;
	}
}
