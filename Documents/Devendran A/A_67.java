package Z_sums;

public class A_67 { // 67.Java Program to print the duplicate elements of an array

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 2, 2, 5, 1, 2 };
		dup(a);

	}

	public static void dup(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				int count = 0;
				for (int j = i + 1; j < a.length; j++) {
					if (a[i] == a[j]) {
						count++;
						a[j] = 0;
					}
				}
				if (count > 0) {
					System.out.println(a[i] + " has " + count + " duplicate");
				}
			}
		}
	}
}
