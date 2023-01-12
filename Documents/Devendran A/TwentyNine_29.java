package zohosums;

import java.util.Scanner;

public class TwentyNine_29 {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a charactor : ");
		char c = s.next().toUpperCase().charAt(0);
		switch (c) {
		case 'A' -> System.out.println("Its a Vowel ");
		case 'E' -> System.out.println("Its a Vowel ");
		case 'I' -> System.out.println("Its a Vowel ");
		case 'O' -> System.out.println("Its a Vowel ");
		case 'U' -> System.out.println("Its a Vowel ");
		default ->System.out.println("The entered charactor is a Consonent ");
		}
	}
}
