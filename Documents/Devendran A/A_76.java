package Z_sums;

public class A_76 { // 76.Java Program to display the transpose matrix
	public static void main(String[] args) {
		int[][] a = { { 1, 2, -1 }, { 3, 0, 4 } };
		p(a);
		System.out.println();
		if (check(a)) {
			int[][] b = new int[a[0].length][a.length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					b[j][i] = a[i][j];
				}
			}
			p(b);
		} else {
			System.out.println("The matrix columns are not even so cant convert to transpose matrix");
		}
	}

	public static boolean check(int[][] a) {
		int count = 0;
		int c = a[0].length;
		for (int i = 0; i < a.length; i++) {
			if (c == a[i].length) {
				count++;

			}
		}
		if (count == a.length) {
			return true;
		}
		return false;
	}

	public static void p(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
