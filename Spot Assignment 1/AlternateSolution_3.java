package mid_jan;

import java.util.ArrayList;

public class AlternateSolution_3 {
	static ArrayList<String> check = new ArrayList<>();

	public static void main(String[] args) {
		String[] a = { "ceo", "alco", "caaeio", "ceai" };
		String[] b = { "ec", "oc", "ceo" };

		ArrayList<String> res = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			subSeq("", a[i]);
			String s = reverse(a[i]);
			subSeq("", s);
			int count = 0;
			for (int j = 0; j < b.length; j++) {
				if (check.contains(b[j])) {
					count++;
				}
			}
			if (count == b.length) {
				res.add(a[i]);
			}
			check.clear();
		}
		System.out.println(res);
	}

	public static void subSeq(String res, String org) {
		if (org.length() == 0) {
			check.add(res);
			return;
		}
		subSeq(res + org.charAt(0), org.substring(1));
		subSeq(res, org.substring(1));
	}

	public static String reverse(String s) {
		if (s.length() == 0) {
			return s;
		}
		return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
	}

}
