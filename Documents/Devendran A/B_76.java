package Z_sums;

public class B_76 { // 76.Java Program to display the transpose matrix
	public static void main(String[] args) {
		int[][] a = { { 1, 2, -1 }, { 3, 0, 4 } };

		if (A_1methods.colEqMatrix(a)) {
			A_1methods.pp(a);
			System.out.println();
			int res[][] = new int[a[0].length][a.length];
			sol(a, res, 0);
			A_1methods.pp(res);
		} else {
			System.out.println("Try the matrix of equal columns ");
		}
	}

	public static void sol(int[][] a, int[][] res, int i) {
		if (i < a.length) {
			j(a, res, 0, i);
			sol(a, res, ++i);
		}
	}

	private static void j(int[][] a, int[][] res, int j, int i) {
		if (j < a[0].length) {
			res[j][i] = a[i][j];
			j(a, res, ++j, i);
		}
	}
}
