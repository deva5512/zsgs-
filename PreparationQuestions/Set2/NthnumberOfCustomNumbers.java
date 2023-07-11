package PreparationQuestions;

public class NthnumberOfCustomNumbers {

	public static void main(String[] args) {
		int n = 14;
		findNthNumber(n);
	}

	private static void findNthNumber(int n) {
		if (n <= 2) {
			System.out.println(n == 0 ? 0 : n == 1 ? 3 : 4);
			return;
		}
		String[] arr = new String[n];
		arr[0] = "3";
		arr[1] = "4";
		int s = 0;
		int ind = 2;
		while (ind < arr.length) {
			int end = ind;
			for (int i = s; i < end && ind < arr.length; i++) {
				arr[ind++] = '3' + arr[i];
			}
			for (int i = s; i < end && ind < arr.length; i++) {
				arr[ind++] = '4' + arr[i];
			}
			s = end;
		}
		System.out.println(arr[n - 1]);
	}

}
