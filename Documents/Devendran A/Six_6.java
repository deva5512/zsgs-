package zohosums;

public class Six_6 {
	public static void main(String[] args) {
		int[] a = new int[20];
		int num = 101;
		for (int i = 0; i < a.length; i++) {
			a[i] = num++;
		}

		int[] g1 = new int[a.length / 4];
		int[] g2 = new int[a.length / 4];
		int[] g3 = new int[a.length / 4];
		int[] g4 = new int[a.length / 4];

		int div = 1;
		for (int i = 0, m = 0; i < a.length; i++) {
			if (div == 1) {
				g1[m] = a[i];
				div++;
			} else if (div == 2) {
				g2[m] = a[i];
				div++;
			} else if (div == 3) {
				g3[m] = a[i];
				div++;
			} else {
				g4[m++] = a[i];
				div = 1;
			}
		}
		System.out.println("Group 1");
		print(g1);
		System.out.println("Group 2");
		print(g2);
		System.out.println("Group 3");
		print(g3);
		System.out.println("Group 4");
		print(g4);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}
}
