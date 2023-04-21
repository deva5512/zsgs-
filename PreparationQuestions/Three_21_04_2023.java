package PreparationQuestions;

public class Three_21_04_2023 {
	public static void main(String[] args) {
		int num = 77;
		findSeat(num);
		long [] arr = {1, 1 ,0 ,1 ,0 ,1};
		System.out.println(minMoves(arr, 6));
	}

	private static void findSeat(int num) {
		if (num % 6 == 0 || num % 6 == 1) {
			System.out.println("Window Seat");
		} else if (num % 3 == 0 || num % 3 == 1) {
			System.out.println("Aisle Seat");
		} else {
			System.out.println("Middle Seat");
		}
	}

	public static long minMoves(long arr[], long n) {

		long count = 0;
		long max = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 0;
			}
		}

		max = (long) Math.ceil(max / 2.0);

		if (count > max) {
			max = count;
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				break;
			} else
				count++;
		}

		if (count > max) {
			max = count;
		}

		return max;
	}
}
