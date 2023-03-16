package com.recrutmentmanagement.dto;

public class Resume {
	private String name;
	private String qualification;
	private int YOP;
	private String Skill;
	private long contact;
	private String mail;

	public Resume(String name, String qualification, int yOP, String skill, long number, String mail) {
		this.name = name;
		this.qualification = qualification;
		this.YOP = yOP;
		this.Skill = skill;
		this.contact = number;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public String getQualification() {
		return qualification;
	}

	public int getYOP() {
		return YOP;
	}

	public void setYOP(int yOP) {
		YOP = yOP;
	}

	public String getSkill() {
		return Skill;
	}

	public long getContact() {
		return contact;
	}

	public String getMail() {
		return mail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void setSkill(String skill) {
		Skill = skill;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		System.out.println("+---------------------------------------------+");
		System.out.printf("| %-15s : %-25s |\n", "Name", name);
		System.out.printf("| %-15s : %-25s |\n", "Qualification", qualification);
		System.out.printf("| %-15s : %-25d |\n", "YOP", YOP);
		System.out.printf("| %-15s : %-25s |\n", "Skill", Skill);
		System.out.printf("| %-15s : %-25d |\n", "contact", contact);
		System.out.printf("| %-15s : %-25s |\n", "mail", mail);
		System.out.println("+---------------------------------------------+");
		return "";
	}
}
