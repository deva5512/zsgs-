package PreparationQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class BloodRelation {

	public static void main(String[] args) {
		String[][] arr = { { "luke", "zeak" }, { "marse", "roman" }, { "roman", "ronaldo" }, { "zeak", "roman" } };
		findChildren("ronaldo", 3, arr);
	}

	private static void findChildren(String parent, int generation, String[][] relaiton) {
		Queue<String> outer = new LinkedList<>();
		outer.offer(parent);
		while (!outer.isEmpty() && generation > 0) {
			Queue<String> child = new LinkedList<>();
			while (!outer.isEmpty()) {
				parent = outer.poll();
				for (String[] arr : relaiton) {
					if (equals(arr[1], parent))
						child.offer(arr[0]);
				}
			}
			outer = child;
			generation--;
		}
		System.out.println(outer);
	}

	public static boolean equals(String b, String a) {
		if (b.length() != a.length())
			return false;
		for (int i = 0; i < a.length(); i++)
			if (a.charAt(i) != b.charAt(i))
				return false;
		return true;
	}

}
