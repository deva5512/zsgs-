package mid_jan;

import java.util.HashMap;

public class AlternateSolution_5 {
	public static void main(String[] args) {
		charCounts("Hello World Please", "Help");
	}

	public static void charCounts(String s1, String s2) {
		s1 = s1.trim().toLowerCase();
		s2 = s2.trim().toLowerCase();
		HashMap<Character, Integer> counts = new HashMap<>();
		for (int index = 0; index < s1.length(); index++) {
			if (counts.containsKey(s1.charAt(index))) {
				counts.put(s1.charAt(index), counts.get(s1.charAt(index)) + 1);
			} else
				counts.put(s1.charAt(index), 1);
		}

		for (int index = 0; index < s2.length(); index++) {
			if (counts.get(s2.charAt(index)) != null)
				System.out.println(s2.charAt(index) + " : " + counts.get(s2.charAt(index)));
		}
	}
}
