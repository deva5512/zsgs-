package Z_sums;

import java.util.ArrayList;
import java.util.Iterator;

public class B_62 {
	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> l = new ArrayList<Integer>();
		System.out.print("Even : ");
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				System.out.print(a[i] + " ");
			} else {
				l.add(a[i]);
			}
		}
		System.out.print("\nOdd : ");
		Iterator<Integer> i = l.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}

	}
}
