package zohosums;

import java.util.Scanner;

public class TwentyFout_24 {
	static Scanner s = new Scanner (System.in);
	public static void main(String[] args) {
		System.out.print("Enter a charactor to find its ancii value : ");
		char c = s.next().charAt(0);
		
		System.out.println("Ancii calue of the entered charactor "+c+" is "+(int)c);
	}
}
