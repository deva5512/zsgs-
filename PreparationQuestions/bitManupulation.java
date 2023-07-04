package PrepatationQuestions_1;

import java.util.ArrayList;
import java.util.List;

public class BitManumpuation {

	public static void main(String[] args) {
		singlenumber(new int[] { 5, 2, 3, 6, 1, 2, 3, 6, 1 });
		swap(2, 5);
		System.out.println("xor till " + 4 + " = " + xorTillN(4));
		xorRange(6, 8);
		evenOrOdd(5);
		checkIthBitSetBitOrNot(8, 3);
		setIthBitTo1(8, 3);
		clearIthBit(8, 3);
		removeLastSetBit(3);
		checkNumberPowOf2(8);
		countNumberOfSetBits(7);
		countNumberOfSetBits1(8);
		twoSingleElement(new int[] { 2, 2, 3, 3, 1, 4, 5, 6, 4, 1 });
		subsets(new int[] { 1, 2, 3 });
		setDataStructure();
	}

	static class set {
		long val = 0;

		public boolean add(int val) {
			if (val < 0)
				throw new ArrayIndexOutOfBoundsException("negative index is not permited");
			int mask = 1 << val;
			if ((this.val & mask) != 0)
				return false;
			this.val ^= mask;
			return true;
		}

		public int remove(int val) {
			if (val < 0)
				throw new ArrayIndexOutOfBoundsException("negative index is not permited");
			int mask = 1 << val;
			if ((this.val & mask) == 0)
				return -1;
			this.val ^= mask;
			return val;
		}

		public void print() {
			System.out.print("[");
			long mask = 1;
			for (int i = 1; mask <= val; i++) {
				mask = 1 << i;
				if ((val & mask) != 0)
					System.out.print(" " + i + " ");
			}
			System.out.println("]");
		}
	}

	private static void setDataStructure() {
		set s = new set();
		System.out.println(s.add(5));
		System.out.println(s.add(2));
		System.out.println(s.add(2));
		System.out.println(s.add(1));
		System.out.println(s.add(1));
		System.out.println(s.remove(1));
		System.out.println(s.add(1));
		s.print();
	}

	private static void subsets(int[] arr) {
		int n = 1 << arr.length;
		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>();
			int mask = 1;
			for (int j = 0; j < arr.length; j++) {
				if ((i & mask) != 0)
					list.add(arr[j]);
				mask <<= 1;
			}
			System.out.println(list);
		}
	}

	private static void twoSingleElement(int[] arr) {
		int xor = 0;
		for (int i : arr)
			xor ^= i;
		int a = 0;
		int b = 0;
		int comp = 1;
		while ((comp & xor) == 0)
			comp <<= 1;

		for (int i : arr) {
			if ((i & comp) == 0)
				a ^= i;
			else
				b ^= i;
		}
		System.out.println(a);
		System.out.println(b);
	}

	private static void countNumberOfSetBits1(int num) {
		int count = 0;
		while (num != 0) {
			num &= num - 1;
			count++;
		}
		System.out.println(count + " bits");
	}

	private static void countNumberOfSetBits(int num) {
		int count = 0;
		while (num > 0) {
			if ((num & 1) == 1)
				count++;
			num >>= 1;
		}
		System.out.println(count + " bits");
	}

	private static void checkNumberPowOf2(int num) {
		if ((num & num - 1) == 0)
			System.out.println("its a power of 2");
		else
			System.out.println("its not a power of 2");
	}

	private static void removeLastSetBit(int num) {
		System.out.println(num & num - 1);
	}

	private static void clearIthBit(int num, int i) {
		int mask = 1 << i;
		if ((num & mask) != 0) {
			num ^= mask;
		}
		System.out.println(num);
	}

	private static void setIthBitTo1(int num, int i) {
		int mask = 1 << i;
		num |= mask;
		System.out.println(num);
	}

	public static void singlenumber(int[] nums) {
		int xor = 0;
		for (int i : nums)
			xor = xor ^ i;
		System.out.println(xor);
	}

	public static void swap(int a, int b) {
		System.out.println(a + " " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);
	}

	public static int xorTillN(int n) {
		if (n % 4 == 0)
			return n;
		else if (n % 4 == 1)
			return 1;
		else if (n % 4 == 2)
			return n + 1;
		else
			return 0;
	}

	public static void xorRange(int l, int r) {
		System.out.println("range xor = " + (xorTillN(l - 1) ^ xorTillN(r)));
	}

	public static void evenOrOdd(int num) {
		if ((num & 1) == 0)
			System.out.println("even");
		else
			System.out.println("odd");
	}

	public static void checkIthBitSetBitOrNot(int n, int i) {
		if ((n & (1 << i)) == 0)
			System.out.println("the bit is not setbit");
		else
			System.out.println("it is");
	}
}
