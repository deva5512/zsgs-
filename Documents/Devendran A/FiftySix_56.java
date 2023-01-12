package zohosums;

public class FiftySix_56 {
	public static void main(String[] args) {
		int a = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				if (i + j == 3 || i + 3 == j || (i + j - 2 == 3) && (i > 1) || (i + 1 == j) && (i > 1)) {
					System.out.print(a++ + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
