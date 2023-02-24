package com.cricketscoremanagement.CricketView;

import java.util.List;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.Team;

public interface CricketViewControllerCall {

	int getOver();

	String getTeam1name();

	String getTeam2name();

	void setTeam2PlayerName(List<String> names);

	void setTeam1PlayerName(List<String> names);

	void setTeamName(String team1, String team2);

	void setOvers(int overs);

	List<Player> getTeam2Players();

	List<Player> getTeam1Players();

	char getTossRes(String string);

	void swapTeams();

	String getWinningStatus();

	void SetScoreBoard();

}
