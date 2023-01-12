package Z_sums;

public class C_64 {
	public static void main(String[] args) {
		int[] a = { 1, 5, 6, 45, 8 };
		int b[] = a.clone();
		p(a);
		p(b);

	}

	public static void p(int[] a) {
		System.out.println(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
