package zohosums;

public class FourtyTwo_42 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 2, 1, 2, 6, 3, 8, 4 };

		int count = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
					a[j] = 0;
				}
			}
			if (a[i] != 0) {
				System.out.println(a[i] + " :  " + count);
			}
			count = 1;
		}
	}
}
