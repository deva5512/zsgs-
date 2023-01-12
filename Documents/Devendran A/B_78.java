package Z_sums;

public class B_78 {
	public static void main(String[] args) {
		int[][] a = { { 1, 5 }, { 2, 26 } };
		int[][] b = { { 1, 5 }, { 2, 6 } };
		if (a.length == b.length && a[0].length == b[0].length && A_1methods.colEqMatrix(a)
				&& A_1methods.colEqMatrix(b)) {
			int[][] res = new int[a.length][a[0].length];
			res = sub(a, b, res, 0);
			A_1methods.pp(res);
		} else {
			System.out.println("Cant able to perform the specific operation because of improper size");
		}

	}

	private static int[][] sub(int[][] a, int[][] b, int[][] res, int i) {
		if (i < a.length) {
			sub1(a, b, res, 0, i);
			sub(a, b, res, ++i);
		}
		return res;
	}

	private static void sub1(int[][] a, int[][] b, int[][] res, int j, int i) {
		if (j < a[0].length) {
			res[i][j] = a[i][j] - b[i][j];
			sub1(a, b, res, ++j, i);
		}
	}

}
