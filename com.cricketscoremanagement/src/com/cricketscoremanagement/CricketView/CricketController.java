package com.cricketscoremanagement.CricketView;

import java.util.List;
import java.util.Random;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.Team;

public class CricketController implements CricketViewControllerCall, CricketModelControllerCall {

	private CricketViewCallBack cricketView;
	private CricketModelCallBack cricketModel;

	public CricketController(CricketViewCallBack cricketView) {
		this.cricketView = cricketView;
		this.cricketModel = new CricketModel(this);
	}

	@Override
	public int getOver() {
		return cricketModel.getOver();
	}

	@Override
	public String getTeam1name() {
		return cricketModel.getTeam1name();
	}

	@Override
	public String getTeam2name() {
		return cricketModel.getTeam2name();
	}

	@Override
	public void setTeamName(String team1, String team2) {
		cricketModel.setTeamName(team1, team2);
	}

	@Override
	public void setTeam2PlayerName(List<String> names) {
		cricketModel.setTeam2PlayerName(names);
	}

	@Override
	public void setTeam1PlayerName(List<String> names) {
		cricketModel.setTeam1PlayerName(names);
	}

	@Override
	public void setOvers(int overs) {
		cricketModel.setOvers(overs);
	}

	@Override
	public List<Player> getTeam2Players() {
		return cricketModel.getTeam2Players();
	}

	@Override
	public List<Player> getTeam1Players() {
		return cricketModel.getTeam1Players();
	}

	@Override
	public char getTossRes(String string) {
		Random r = new Random();

		int i = r.nextInt(string.length());

		return string.charAt(i);
	}

	@Override
	public void swapTeams() {
		cricketModel.swapTeam();
	}

	@Override
	public String getWinningStatus() {
		return cricketModel.getWinner();
	}

	@Override
	public void SetScoreBoard() {
		cricketModel.SetScoreBoard();
	}

}
