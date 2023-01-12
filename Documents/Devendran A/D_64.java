package Z_sums;

public class D_64 {
	public static void main(String[] args) {
		int[] a = { 12, 45, 64, 9, 6, 6, 3, 2, 5, 6, 63, 4 };
		int[] b = new int[a.length];
		c(a, b, 0);
		p(a, 0);
		System.out.println();
		p(b, 0);
	}

	public static void c(int[] a, int[] b, int l) {
		if (l < a.length) {
			b[l] = a[l];
			c(a, b, ++l);
		}
	}

	public static void p(int[] a, int i) {
		if (i < a.length) {
			System.out.print(a[i++] + " ");
			p(a, i);
		}
	}
}
