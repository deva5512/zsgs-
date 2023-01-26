package mid_jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlternateSolution_2 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the size of the Array : ");
		int[] array = new int[s.nextInt()];
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter the element : ");
			array[i] = s.nextInt();
		}

		int len = total(array);
		if (len % 2 == 1) {
			System.out.println("Cant able to split");
		} else {
			findPosition(array, len / 2);
			if (res.isEmpty()) {
				System.out.println("Cant able to split");
			} else {
				for (int[] a : res) {
					System.out.println(Arrays.toString(a));
				}
			}
		}

		findPosition(array, array.length);
	}

	static ArrayList<int[]> res = new ArrayList<>();

	public static void findPosition(int[] arr, int n) {
		int sum = 0;

		int starting = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum == n) {
				res.add(Arrays.copyOfRange(arr, 0, i));
				starting = i;
				sum = 0;
			}
			sum += arr[i];
		}
		if (sum == n) {
			res.add(Arrays.copyOfRange(arr, starting, arr.length));
		} else {
			res.clear();
		}

	}

	public static int total(int[] a) {
		int total = 0;
		for (int i : a) {
			total += i;
		}
		
		return total; 
	}
}
