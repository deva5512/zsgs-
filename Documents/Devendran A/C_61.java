package Z_sums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class C_61 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i : a) {
			ar.add(i);
		}
		Collections.reverse(ar);
		Iterator<Integer> i = ar.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
}
