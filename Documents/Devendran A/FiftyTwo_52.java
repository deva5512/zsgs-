package zohosums;

import java.util.Scanner;

public class FiftyTwo_52 {
	static Scanner s = new Scanner(System.in);
	static String res = "";
	public static void main(String[] args) {
		System.out.println("Enter a String : ");
		String w = s.nextLine();
		String [] a = w.split(" ");
		int len = a.length-1;
		rev(a,len);
		System.out.println(res);
	}
	public static void rev(String s [], int n) {
		if(n>=0) {
			res += s[n--]+" ";
			rev(s,n);
		}
	}
}
