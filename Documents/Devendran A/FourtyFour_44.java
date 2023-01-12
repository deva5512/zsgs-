package zohosums;

public class FourtyFour_44 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 2, 1, 2, 6, 3, 8, 4 };

		for (int i = 0; i < a.length; i++) {
			int count = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
					a[j] = 0;
				}
			}
			if (a[i] != 0 && count > 1) {
				System.out.println(a[i] + "  :  " + count + " times");
			}
		}
	}
}
