package Z_sums;

public class A_62 {
	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		main(a, 1, "Odd");
		main(a, 0, "Even");

	}

	public static void main(int[] a, int key, String o_e) {
		System.out.print(o_e + " : ");
		for (int i = key; i < a.length; i += 2) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
