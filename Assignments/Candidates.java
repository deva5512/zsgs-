package StackAndQueue;

import java.util.Random;

public class Candidates {

	// Each and every candidate will have unique id's
	int id_no;
	String name;
	int age;
	String experience;

	public Candidates(int n) {
		this.id_no = n;
		this.name = nameGenerator();
		this.age = ageGenerator();

		// Based on the candidate age experience will be assigned
		if (age < 24) {
			this.experience = "Fresher";
		} else {
			this.experience = "Experienced";
		}
	}

	private static Random r = new Random();

	// Method to generate Candidate name randomly
	private String nameGenerator() {
		char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		String res = "";

		// This loop will select 4 random letters as the candidate name
		for (int i = 0; i < 4; i++) {
			int letter = r.nextInt(ch.length);
			res += ch[letter];
		}
		return res;
	}

	// Method to generate candidate age randomly
	private int ageGenerator() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int res = 20;
		int index = r.nextInt(a.length);
		return res + a[index];
	}

	@Override
	public String toString() {
		System.out.println("Id no : " + this.id_no);
		System.out.println("Name : " + this.name);
		System.out.println("Age : " + this.age);
		System.out.println("Experience : " + this.experience);
		return "";
	}
}
