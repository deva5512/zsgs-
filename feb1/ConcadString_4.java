package feb1;

import java.util.Arrays;
import java.util.Scanner;

public class ConcadString_4 {
	public static void main(String[] args) {

//		Scanner s = new Scanner(System.in);

		ConcadString_4 con = new ConcadString_4();

//		System.out.println("Enter the array Size : ");
//		int size = s.nextInt();
//		s.nextLine();
//
		String[] strings = { "tab", "tabcb", "abt" ,"bbb","b","b"};
//		String[] strings = { "opara", "abc", "atom", "money", "ckkka" };
//		for (int i = 0; i < strings.length; i++) {
//			System.out.println("Enter the element : ");
//			strings[i] = s.nextLine();
//		}
		for (int i = 0; i < strings.length; i++) {
			strings[i] = strings[i].toLowerCase();
		}
		System.out.println(con.concat(strings));
	}

	public String concat(String[] strings) {
		String res = "";
		int i = 0;

		// it will decide which string's last character has to be used
		boolean check = true;

		String found = "";

		// It will maintain avoid entering into same string
		boolean[] verify = new boolean[strings.length];

		// i will iterate through all strings
		while (i < strings.length) {
			char ch = '0';
			verify[i] = true;
			if (check) {
				found += strings[i];
			}
			ch = found.charAt(found.length() - 1);

			int pre = found.length();
			String got = "";

			for (int j = 0; j < strings.length; j++) {
				if (!verify[j]) {
					if (strings[j].charAt(0) == ch && got.length() < strings[j].length()) {
						got = strings[j];
						check = false;
						verify[j] = true;
					}
				}
			}
			found += got;

			// If the length chages it will move to the next position
			if (found.length() == pre) {
				if (res.length() < found.length()) {
					res = found;
				}
				found = "";
				check = true;
				i++;
				Arrays.fill(verify, false);
			}
		}

		return res;
	}
}
