package Z_sums;

public class A_74 { // 74.Java Program to find the product of two matrices

	public static void main(String[] args) {
		int[][] a = { { 6, 11 }, { 3, 4 } };
		int[][] b = { { 6, 7 }, { 8, 9 } };
		pro(a, b);
	}

	public static void pro(int a[][], int b[][]) {
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Cant able to get produt of the matrix is not in the same length ");
			return;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] * b[i][j] + " ");
			}
			System.out.println();
		}

	}
}
