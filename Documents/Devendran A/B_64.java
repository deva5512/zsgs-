package Z_sums;

public class B_64 {
	public static void main(String[] args) {
		int a[] = { 5, 4, 8, 9, 7, 5, 6, 1, 2, 3, 5 };
		B_64 ref = new B_64();
		int b[] = ref.copy(a);
		ref.p(a);
		ref.p(b);

	}

	public int[] copy(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public void p(int[] a) {
		System.out.println(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
