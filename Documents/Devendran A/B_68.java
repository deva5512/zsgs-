package Z_sums;

public class B_68 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 10 };
		System.out.println("Sum of Array is : " + sum(a, 0, 0));
	}

	public static int sum(int[] a, int sum, int i) {
		if (i < a.length) {
			int addition = sum(a, a[i], ++i);
			sum += addition;
		}
		return sum;
	}
}
