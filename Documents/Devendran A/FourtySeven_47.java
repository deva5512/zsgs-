package zohosums;

import java.util.Scanner;

public class FourtySeven_47 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the no of lines : ");
		int no = s.nextInt();
		int t = no;
		int r = no;
		int p = 1;

		int[][] a = new int[no][no * 2 - 1];
		for (int c = 0; c < no; c++) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if ((i + j >= t - 1 && j < no) || (i + r - 1 >= j && j >= no - 1)) {
						a[i][j] = p;
					}
				}
			}
			t += 1;
			r -= 1;
			p += 1;
		}
		print(a);
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != 0)
					System.out.print(a[i][j] + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
