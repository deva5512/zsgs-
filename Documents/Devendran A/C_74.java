package Z_sums;

public class C_74 {
	static int[][] res;

	public static void main(String[] args) {
		int[][] a = { { 6, 11 }, { 3, 4 } };
		int[][] b = { { 6, 7 }, { 8, 9 } };

		if (a.length == b.length && a[0].length == b[0].length) {
			res = new int[a.length][a[0].length];
			pro(a, b, 0);
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[i].length; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Cant able to get product of matrices because of improper size ");
		}

	}

	public static void pro(int[][] a, int[][] b, int i) {

		if (i < a.length) {
			j(a, b, 0, i);
			pro(a, b, ++i);
		}
	}

	public static void j(int[][] a, int[][] b, int j, int i) {
		if (j < a[0].length) {
			res[i][j] = a[i][j] * b[i][j];
			j(a, b, ++j, i);
		}
	}
}
