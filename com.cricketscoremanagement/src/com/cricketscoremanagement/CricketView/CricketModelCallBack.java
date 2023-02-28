package com.cricketscoremanagement.CricketView;

import java.util.List;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.Team;

public interface CricketModelCallBack {

	int getOver();

	String getTeam1name();

	String getTeam2name();

	void setOvers(int overs);

	void setTeam2PlayerName(List<String> names);

	void setTeam1PlayerName(List<String> names);

	void setTeamName(String team1, String team2);

	List<Player> getTeam2Players();

	List<Player> getTeam1Players();

	void swapTeam();

	String getWinner();

	void SetScoreBoard();

}
