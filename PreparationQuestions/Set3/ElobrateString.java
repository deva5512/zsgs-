package PreparationQuestions.Set3;

public class ElobrateString {

//	Eg 1: Input: a1b10
//    Output: abbbbbbbbbb
//  Eg: 2: Input: b3c6d15
//       Output: bbbccccccddddddddddddddd
//	The number varies from 1 to 99.

	public static void main(String[] args) {
		String str = "b3c6d15";
		evlove(str);
	}

	private static void evlove(String str) {
		String res = "";
		char ch = str.charAt(0);
		int count = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
				count = count * 10 + (str.charAt(i) - '0');
			else {
				res += repeat(ch, count);
				ch = str.charAt(i);
				count = 0;
			}
		}
		res += repeat(ch, count);
		System.out.println(res);
	}

	public static String repeat(char ch, int count) {
		StringBuilder sb = new StringBuilder();
		while (count-- > 0)
			sb.append(ch);
		return new String(sb);
	}

}
