package Feb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Password_4 {
	public static void main(String[] args) {
		List<String> real = new ArrayList<>();
		System.out.println("Enter the real passwords :");

		String pass = TwoFriends_1.s.nextLine();

		for (String s : pass.split(" ")) {
			real.add(s);
		}

		System.out.println("Enter the password to check : ");
		String check = TwoFriends_1.s.nextLine();

		List<String> list = new ArrayList<>();

		if (!passwordCheck(real, check, list, 1)) {
			System.out.println("Wrong Password");
		} else {
			Iterator<String> it = list.iterator();

			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
		}

	}

	public static boolean passwordCheck(List<String> realPass, String useit, List<String> res, int ind) {
		if (useit.isEmpty()) {
			return true;
		}
		if (ind == useit.length() + 1) {
			return false;
		}
		String word = useit.substring(0, ind);
		if (realPass.contains(word)) {

			// If we found the password make the index 0 and add the useful password into
			// the list and remove the unwanted word from the string
			res.add(word);
			useit = useit.replace(word, "");
			ind = 0;
		}
		return passwordCheck(realPass, useit, res, ind + 1);

	}
}
