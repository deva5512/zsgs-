package com.cricketscoremanagement.CricketView;

import java.util.List;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.Team;

import repository.ScoreManagementDb;

public class CricketModel implements CricketModelCallBack {

	private CricketModelControllerCall cricketcontroller;

	public CricketModel(CricketModelControllerCall cricketController) {
		this.cricketcontroller = cricketController;
	}

	@Override
	public int getOver() {
		return ScoreManagementDb.getInstance().getNumber_overs();
	}

	@Override
	public String getTeam1name() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam_name();
	}

	@Override
	public String getTeam2name() {
		return ScoreManagementDb.getInstance().getTeam2().getTeam_name();
	}

	@Override
	public void setOvers(int overs) {
		ScoreManagementDb.getInstance().setNumber_overs(overs);
	}

	@Override
	public void setTeam2PlayerName(List<String> names) {
		List<Player> player = ScoreManagementDb.getInstance().getTeam2().getTeam();

		for (int i = 0; i < player.size(); i++) {
			player.get(i).setName(names.get(i));
		}
	}

	@Override
	public void setTeam1PlayerName(List<String> names) {
		List<Player> player = ScoreManagementDb.getInstance().getTeam1().getTeam();

		for (int i = 0; i < player.size(); i++) {
			player.get(i).setName(names.get(i));
		}
	}

	@Override
	public void setTeamName(String team1, String team2) {
		ScoreManagementDb.getInstance().getTeam1().setTeam_name(team1);
		ScoreManagementDb.getInstance().getTeam2().setTeam_name(team2);
	}

	@Override
	public List<Player> getTeam2Players() {
		return ScoreManagementDb.getInstance().getTeam2().getTeam();
	}

	@Override
	public List<Player> getTeam1Players() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam();
	}

	@Override
	public void swapTeam() {
		ScoreManagementDb.getInstance().swapTeamsInBoard();
	}

	@Override
	public String getWinner() {
		return ScoreManagementDb.getInstance().getWinning_team();
	}

	@Override
	public void SetScoreBoard() {
		ScoreManagementDb.getInstance().secondScoreBoard();
	}

}
