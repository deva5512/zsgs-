package Z_sums;

public class B_70 {
	static int larg = 0, res;

	public static void main(String[] args) {
		int[] a = { 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 2 };
		System.out.print("Enter a number : ");
		int num = A_70.s.nextInt();
		System.out.println(lar(a, num, 0));
	}

	public static int lar(int[] a, int lar, int l) {
		if (l < lar) {
			res = i(a, 0);
			remover(a, 0, larg);
			larg = 0;
			lar(a, lar, ++l);
		}
		return res;
	}

	public static int i(int a[], int i) {
		if (i < a.length) {
			if (larg < a[i]) {
				larg = a[i];
			}
			i(a, ++i);
		}
		return larg;
	}

	public static void remover(int[] a, int n, int key) {
		if (n < a.length) {
			if (a[n] == key) {
				a[n] = -1;
			}
			remover(a, ++n, key);
		}
	}
}
