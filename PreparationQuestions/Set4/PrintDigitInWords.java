package PreparationQuestions.Set4;

import java.util.HashMap;
import java.util.Map;

public class PrintDigitInWords {

	static Map<Integer, String> map = new HashMap<>();

	static {
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "fourty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninety");
	}

	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++)
			printToWord(i);
	}

	private static void printToWord(int num) {
		int mult = 1;
		for (int i = 1; i < (num + "").length(); i++) {
			mult *= 10;
		}
		String res = "";
		while (num > 0 && !map.containsKey(num)) {
			int rem = num / mult;
			rem *= mult;
			num = num % mult;
			if (map.containsKey(rem)) {
				res += map.get(rem) + " ";
			} else {
				res += map.get(rem / mult) + " hundred";
				if (num > 0)
					res += " and ";
			}
			mult /= 10;
		}
		if (num > 0)
			res += map.get(num);
		System.out.println(res);
	}

}
