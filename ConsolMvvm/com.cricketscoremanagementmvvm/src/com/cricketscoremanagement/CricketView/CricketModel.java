package com.cricketscoremanagement.CricketView;

import java.util.List;
import java.util.Random;

import com.cricketscoremanagement.dto.Player;

import repository.ScoreManagementDb;

public class CricketModel {

	private CricketView cricketView;

	public CricketModel(CricketView cricketView) {
		this.cricketView = cricketView;
	}

	public int getOver() {
		return ScoreManagementDb.getInstance().getNumber_overs();
	}

	public String getTeam1name() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam_name();
	}

	public String getTeam2name() {
		return ScoreManagementDb.getInstance().getTeam2().getTeam_name();
	}

	public void setOvers(int overs) {
		ScoreManagementDb.getInstance().setNumber_overs(overs);
	}

	public void setTeam2PlayerName(List<String> names) {
		List<Player> player = ScoreManagementDb.getInstance().getTeam2().getTeam();

		for (int i = 0; i < player.size(); i++) {
			player.get(i).setName(names.get(i));
		}
	}

	public void setTeam1PlayerName(List<String> names) {
		List<Player> player = ScoreManagementDb.getInstance().getTeam1().getTeam();

		for (int i = 0; i < player.size(); i++) {
			player.get(i).setName(names.get(i));
		}
	}

	public void setTeamName(String team1, String team2) {
		ScoreManagementDb.getInstance().getTeam1().setTeam_name(team1);
		ScoreManagementDb.getInstance().getTeam2().setTeam_name(team2);
	}

	public List<Player> getTeam2Players() {
		return ScoreManagementDb.getInstance().getTeam2().getTeam();
	}

	public List<Player> getTeam1Players() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam();
	}

	public void swapTeam() {
		ScoreManagementDb.getInstance().swapTeamsInBoard();
	}

	public String getWinner() {
		return ScoreManagementDb.getInstance().getWinning_team();
	}

	public void SetScoreBoard() {
		ScoreManagementDb.getInstance().secondScoreBoard();
	}
	
	public char getTossRes(String string) {
		Random r = new Random();

		int i = r.nextInt(string.length());

		return string.charAt(i);
	}
}
