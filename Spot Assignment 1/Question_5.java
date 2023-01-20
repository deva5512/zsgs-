package mid_jan;

public class Question_5 {
	public static void main(String[] args) {
		String s = "Hello World Please";
		String ref = "Help";
		String temp = ref.toLowerCase();
		s = s.trim().toLowerCase();
		for (int i = 0; i < ref.length(); i++) {
			System.out.println(ref.charAt(i) + " : " + countChars(s, temp.charAt(i)));
		}
	}

	// Method which counts the character present in the string
	public static int countChars(String org, char ch) {
		if (org.length() == 0) {
			return 0;
		}
		if (org.charAt(0) == ch) {
			return 1 + countChars(org.substring(1), ch);
		}
		return countChars(org.substring(1), ch);
	}
}

