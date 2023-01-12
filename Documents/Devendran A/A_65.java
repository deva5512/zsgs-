package Z_sums;

public class A_65 { // 65.Java Program to find the frequency of each element in the array
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 1, 2, 5, 4, 1, 2, 6, 3, 2, 1, 5, 8, 9, 7, 7, 7, 7, 7 };
		frequency(a);

	}

	public static void frequency(int[] a) {
		int count = 1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				for (int j = i + 1; j < a.length; j++) {
					if (a[i] == a[j]) {
						count++;
						a[j] = 0;
					}
				}
				System.out.println(a[i] + " " + count);
				count = 1;
			}
		}
	}
}
