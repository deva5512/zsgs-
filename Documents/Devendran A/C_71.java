package Z_sums;

public class C_71 {
	static int sma = 0, res;

	public static void main(String[] args) {
		int[] a = { 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 2, -1 };
		System.out.print("Enter a number : ");
		int num = A_70.s.nextInt();
		int ans = lar(a, num, 0);
		if (ans == 1000) {
			System.out.println(num + " Smallest number not found ");
		} else {
			System.out.println(ans);
		}
	}

	public static int lar(int[] a, int lar, int l) {
		if (l < lar) {
			sma = a[0];
			res = i(a, 0);
			remover(a, 0, sma);
			lar(a, lar, ++l);
		}
		return res;
	}

	public static int i(int a[], int i) {
		if (i < a.length) {
			if (sma > a[i]) {
				sma = a[i];
			}
			i(a, ++i);
		}
		return sma;
	}

	public static void remover(int[] a, int n, int key) {
		if (n < a.length) {
			if (a[n] == key) {
				a[n] = 1000;
			}
			remover(a, ++n, key);
		}
	}
}
