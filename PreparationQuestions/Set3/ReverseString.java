package PreparationQuestions.Set3;

public class ReverseString {

//	Eg 1: Input: one two three
//   	Output: three two one
//  Eg 2: Input: I love india
//   	Output: india love I 

	public static void main(String[] args) {
		String s = "I love india";
		System.out.println(reverse(s, s.length() - 1));
	}

	public static String reverse(String s, int ind) {
		String res = "";
		for (; ind >= 0; ind--) {
			if (s.charAt(ind) == ' ') {
				res = res + " " + reverse(s, ind - 1);
				break;
			} else
				res = s.charAt(ind) + res;
		}
		return res;
	}

}
