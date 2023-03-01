package feb1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Logical_3 {
	public static void main(String[] args) {
		int[] a = {};
		int total = Arrays.stream(a).sum();

		if (total % 2 == 0) {

			int req = total / 2;

			// This list will fetch the posible indexes whose sum up can make the required
			List<Integer> list = new ArrayList<>();

			check(list, a, req, 0);
			
			System.out.println(list);
			if (list.size() == 0 || list.size() == a.length) {
				System.out.println("Invalid input ");
				return;
			}

			System.out.println("Group 1 :");
			for (int i = 0; i < a.length; i++) {
				if (!list.contains(i))
					System.out.print(a[i] + " ");
			}
			System.out.println("\nGroup 2 : ");
			Iterator<Integer> it = list.iterator();

			while (it.hasNext()) {
				System.out.print(a[it.next()] + " ");
			}

		} else {
			System.out.println("Invalid ");
		}
	}

	private static boolean check(List<Integer> list, int[] a, int req, int ind) {
		if (req == 0) {
			return true;
		}

		for (int i = ind; i < a.length; i++) {
			req -= a[i];
			if (req >= 0) {
				list.add(i);
				if (check(list, a, req, i + 1)) {
					return true;
				}
				list.remove(list.size() - 1);
			}
			req += a[i];
		}
		return false;
	}

}
