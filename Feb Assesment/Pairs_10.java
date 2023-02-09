package Feb;

public class Pairs_10 {
	public static void main(String[] args) {
		System.out.println("Enter the size of the array : ");
		int[] num = new int[TwoFriends_1.s.nextInt()];

		for (int i = 0; i < num.length; i++) {
			System.out.print("element : ");
			num[i] = TwoFriends_1.s.nextInt();
		}

		System.out.println("Enter the k value : ");
		int k = TwoFriends_1.s.nextInt();

		System.out.println("Number of pairs : " + pairs(num, k));
	}

	public static int pairs(int[] arr, int k) {

		int count = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int first = arr[i];
				int sec = arr[j];
				if ((first + sec) % k == 0) {
					count++;
					System.out.println(first + " " + sec);
				}
			}
		}
		return count;
	}
}
