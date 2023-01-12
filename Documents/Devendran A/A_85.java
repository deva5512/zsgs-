package Z_sums;


public class A_85 { // 85.Java Program to find the sum of each row and each column of a matrix

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 1, 2, 3 } };
		if (A_1methods.squarMatrix(a)) {
			Sum(a);
		} else if (A_1methods.colEqMatrix(a)) {
			rowSum(a);
			colSum(a);
		} else {
			System.out.println("Try to add a proper matrix to add ");
		}
	}

	public static void Sum(int[][] a) {
		int rsum = 0;
		int csum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				rsum += a[i][j];
				csum += a[j][i];
			}
			System.out.println(1 + i + " row sum : " + rsum);
			System.out.println(1 + i + " col sum : " + csum);
			rsum = 0;
			csum = 0;
		}
	}

	public static void rowSum(int[][] a) {
		int rsum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				rsum += a[i][j];
			}
			System.out.println(1 + i + " row sum : " + rsum);
			rsum = 0;
		}
	}

	public static void colSum(int[][] a) {
		int csum = 0;
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				csum += a[j][i];
			}
			System.out.println(1 + i + " col sum : " + csum);
			csum = 0;
		}
	}

}
