package Feb;

public class CountSort_2 {
	public static void main(String[] args) {
		System.out.println("Enter the length of the String array : ");

		String[] arr = new String[TwoFriends_1.s.nextInt()];
		TwoFriends_1.s.nextLine();

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the element : ");
			arr[i] = TwoFriends_1.s.nextLine();
		}
//
//		String arr[] = { "0 ab", "6 cd", "0 ef", "6 gh", "4 ij", "0 ab", "6 cd", "0 ef", "6 gh", "0 ij", "4 that",
//				"3 be", "0 to", "1 be", "5 question", "1 or", "2 not", "4 is", "2 to", "4 the" };
		helper(arr);

	}

	public static void helper(String[] arr) {
		int half = arr.length / 2;

		// Before sorting the first half is converted into ' - '
		for (int i = 0; i < half; i++) {
			arr[i] = arr[i].charAt(0) + "- ";
		}

		counting(arr);

		// print the sorted array without index
		for (int i = 0; i < arr.length; i++) {
			String rep = arr[i].charAt(0) + "";
			rep = arr[i].replace(rep, "");
			System.out.print(rep + " ");
		}
	}

	public static void counting(String[] words) {

		// Created a copy of original array
		String[] temp = words.clone();

		// The range is 10
		int count[] = new int[10];

		// Used to count the frequency of the number
		for (int i = 0; i < temp.length; i++) {
			int index = temp[i].charAt(0) - '0';
			count[index]++;
		}

		// Cumulative sum of the count
		for (int i = 1; i < count.length; i++)
			count[i] += count[i - 1];

		// Rearrange the words based on the first index
		for (int i = words.length - 1; i >= 0; i--) {
			int index = temp[i].charAt(0) - '0';
			words[count[index] - 1] = temp[i];
			count[index]--;
		}

	}
}
