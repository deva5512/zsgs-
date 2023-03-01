package feb1;

import java.util.ArrayList;
import java.util.List;

public class NumericalSkills_1 {

	public static void main(String[] args) {
		NumericalSkills_1 n = new NumericalSkills_1();
		n.printValidNumbers(6);
	}

	public void printValidNumbers(int num) {

		System.out.println("Even numbers :");
		List<Integer> odds = new ArrayList<>();

		// First find all the even numbers and add the odd numbers along with it
		while (!isPrime(++num)) {
			if (num % 2 == 0)
				System.out.print(" " + num);
			else {
				odds.add(num);
			}
		}

		System.out.println("\nOdd Numbers : ");
		for (int i = odds.size() - 1; i >= 0; i--) {
			System.out.print(" " + odds.get(i));
		}
	}

	public boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
