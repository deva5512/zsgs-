package mid_jan;

import java.util.ArrayList;

public class Question_3 {
	public static void main(String[] args) {
		String[] x = { "ceo", "alco", "caaeio", "ceai" };
		String[] y = { "ec", "oc", "ceo" };
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < x.length; i++) {
			if (superString(x[i], y)) {
				res.add(x[i]);
			}
		}
		System.out.println(res);
	}

	public static boolean superString(String s, String[] y) {
		for (int i = 0; i < y.length; i++) {
			int len = y[i].length();
			int verify = 0;
			for (int j = 0; j < y[i].length(); j++) {
				char ch = y[i].charAt(j);
				if (s.indexOf(ch) != -1) {
					verify++;
				}
			}
			if (verify != len) {
				return false;
			}
		}
		return true;
	}
}
