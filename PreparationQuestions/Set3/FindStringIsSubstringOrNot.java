package PreparationQuestions.Set3;

public class FindStringIsSubstringOrNot {
	
//	Eg 1:Input:
//        String 1: test123string
//         String 2: 123
//        Output: 4
//	Eg 2: Input:
//        String 1: testing12
//        String 2: 1234 
//        Output: -1

	public static void main(String[] args) {
		String a = "testing12";
		String b = "123";
		System.out.println(substring(a, b));
	}

	public static int substring(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			int j = 1;
			if (a.charAt(i) == b.charAt(0))
				for (; j < b.length() && i + j < a.length(); j++)
					if (a.charAt(i + j) != b.charAt(j))
						break;
			if (j == b.length())
				return i;
		}
		return -1;
	}

}
