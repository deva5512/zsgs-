package PrepatationQuestions_1;

public class GoodBadMixed {

	/*
	 * You have to classify a string as “GOOD”, “BAD” or “MIXED”. A string is
	 * composed of lowercase alphabets and ‘?’. A ‘?’ is to be replaced by any of
	 * the lowercase alphabets. Now you have to classify the string on the basis of
	 * some rules.
	 * 
	 * If there are more than 3 consonants together, the string is considered to be
	 * “BAD”. If there are more than 5 vowels together, the also string is
	 * considered to be “BAD”.
	 * 
	 * A string is “GOOD” if its not “BAD”.
	 * 
	 * 
	 * Now when question marks are involved, they can be replaced with consonants or
	 * vowels to make new strings. If all the choices lead to “GOOD” strings then
	 * the input is considered as “GOOD”, and if all the choices lead to “BAD”
	 * strings then the input is “BAD”, else the string is “MIXED?
	 * 
	 * Example: 1)a?fafff – BAD; 2)??aa?? – MIXED; 3) abc – GOOD
	 */

	public static void main(String[] args) {
		String s = "b?b";
		char[] ch = s.toCharArray();
		String res = "Good";

		for (int i = 2; i < ch.length; i++) {
			int cons = 0;
			int vow = 0;
			int qust = 0;
			int j = i;
			for (; j > i - 3; j--) {
				if (ch[j] == '?')
					qust++;
				else if (ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u')
					vow++;
				else
					cons++;
			}
			if (cons == 3) {
				res = "Bad";
				break;
			} else if ((qust + cons) == 3) {
				res = "Mixed";
			}
			if (i - 5 >= 0) {
				for (; j > i - 5; j--) {
					if (ch[j] == '?')
						qust++;
					else if (ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u')
						vow++;
					else
						cons++;
				}
			}
			if (vow == 5) {
				res = "Bad";
				break;
			} else if ((qust + vow) == 5) {
				res = "Mixed";
			}
		}

		System.out.println(res);
	}

}
