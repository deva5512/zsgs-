package com.cricketscoremanagement.dto;

public class Player {

	private String name;
	private int player_number;
	private int indevidual_score;
	private int no_of_balls;
	private boolean batting_status = true;
	private String status = "-";
	private int numberofWickets;
	private int numberofballsput;

	public Player(Player player) {
		this.name = player.getName();
		this.player_number = player.getPlayer_number();
		this.indevidual_score = player.indevidual_score;
		this.no_of_balls = player.no_of_balls;
		this.batting_status = player.batting_status;
		this.status = player.status;
		this.numberofWickets = player.numberofWickets;
		this.numberofballsput = player.numberofballsput;
	}

	public Player(String name, int player_number) {
		this.name = name;
		this.player_number = player_number;
	}

	public String getName() {
		return name;
	}

	public int getIndevidual_score() {
		return indevidual_score;
	}

	public int getNo_of_balls() {
		return no_of_balls;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIndevidual_score(int indevidual_score) {
		this.indevidual_score = indevidual_score;
	}

	public void setNo_of_balls(int no_of_balls) {
		this.no_of_balls = no_of_balls;
	}

	public int getPlayer_number() {
		return player_number;
	}

	public void setPlayer_number(int player_number) {
		this.player_number = player_number;
	}

	public boolean getBatting_status() {
		return batting_status;
	}

	public void setBatting_status(boolean batting_status) {
		this.batting_status = batting_status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumberofWickets() {
		return numberofWickets;
	}

	public void setNumberofWickets(int numberofWickets) {
		this.numberofWickets = numberofWickets;
	}

	public int getNumberofballsput() {
		return numberofballsput;
	}

	public void setNumberofballsput(int numberofballsput) {
		this.numberofballsput = numberofballsput;
	}

}
