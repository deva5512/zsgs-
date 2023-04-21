package PreparationQuestions;

public class Four_19_04_2023 {
	public static void main(String[] args) {
		String[] arr = { "flower", "flow", "fl" };
		commonPrefix(arr);
	}

	public static void commonPrefix(String[] arr) {

		boolean control = true;
		int ind = -1;

		while (control) {
			ind++;
			if (ind >= arr[0].length())
				break;
			char ch = arr[0].charAt(ind);
			for (int i = 1; i < arr.length; i++) {
				if (arr[i].length() <= ind || arr[i].charAt(ind) != ch) {
					control = false;
					break;
				}
			}
		}

		System.out.println(arr[0].substring(0, ind));
	}
}
