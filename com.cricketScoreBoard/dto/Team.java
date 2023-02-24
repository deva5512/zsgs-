package com.cricketscoremanagement.dto;

import java.util.LinkedList;
import java.util.List;

public class Team {

	private List<Player> team = new LinkedList<>();
	private int team_score;
	private String team_name;

	public Team(String team_name) {
		this.team_name = team_name;
		setPlayers();
	}

	public int getTeam_score() {
		return team_score;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_score(int team_score) {
		this.team_score = team_score;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public void setPlayers() {
		for (int i = 1; i <= 11; i++) {
			Player player = new Player(team_name + " player - " + i, i);
			team.add(player);
		}
	}

	public List<Player> getTeam() {
		return team;
	}

	public void setTeam(List<Player> team) {
		this.team = team;
	}

}
