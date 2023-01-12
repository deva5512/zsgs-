package Z_sums;

public class B_74 {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] b = { { 10, 12, 11 }, { 9, 8, 7 } };
		int[][] c = product(a, b);
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] product(int[][] a, int[][] b) {
		int pro[][] = new int[a.length][a[0].length];
		for (int i = 0; i < pro.length; i++) {
			for (int j = 0; j < pro[i].length; j++) {
				pro[i][j] = a[i][j] * b[i][j];
			}
		}
		return pro;
	}
}
