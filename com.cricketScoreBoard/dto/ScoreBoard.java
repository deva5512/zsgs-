package com.cricketscoremanagement.dto;

public class ScoreBoard {

	public Player getp1() {
		return player1;
	}

	public Player getp2() {
		return player2;
	}

	public Player getbow() {
		return bowler;
	}

	public void setp1(Player p1) {
		player1 = p1;
	}

	public void setp2(Player p2) {
		player2 = p2;
	}

	public void setbow(Player bow) {
		bowler = bow;
	}

	private Player player1;
	private Player player2;
	private Team batting_team;
	private Team bowling_team;
	private Player bowler;
	private char[] balls = new char[6];
	private int numberofballs = 0;
	private int over = 0;
	private int required_to_win;
	private int score;
	private int wickets;
	private int ind;

	public ScoreBoard(Player player1, Player player2, Team batting_team, Team bowling_team, Player bowler, int required,
			int score, int wickets) {

		this.player1 = player1;
		this.player2 = player2;
		this.batting_team = batting_team;
		this.bowling_team = bowling_team;
		this.bowler = bowler;
		this.required_to_win = required;
		this.score = score;
		this.wickets = wickets;
	}

	public String getPlayer1() {
		return player1.getName();
	}

	public String getPlayer2() {
		return player2.getName();
	}

	public String getBatting_team() {
		return batting_team.getTeam_name();
	}

	public String getBowling_team() {
		return bowling_team.getTeam_name();
	}

	public String getBowler() {
		return bowler.getName();
	}

	public char[] getBalls() {
		return balls;
	}

	public int getRequired_to_win() {
		return required_to_win;
	}

	public int getScore() {
		return score;
	}

	public int getWickets() {
		return wickets;
	}

	public void setRequired_to_win(int required_to_win) {
		this.required_to_win = required_to_win;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getOver() {
		return over;
	}

	public void setOver(int over) {
		this.over = over;
	}

	public int getNumberofballs() {
		return numberofballs;
	}

	public void setNumberofballs(int numberofballs) {
		this.numberofballs = numberofballs;
	}

	public int getInd() {
		return ind;
	}

	public void setInd(int ind) {
		this.ind = ind;
	}

}
