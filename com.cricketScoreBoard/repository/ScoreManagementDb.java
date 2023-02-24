package repository;

import java.util.Iterator;
import java.util.List;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;
import com.cricketscoremanagement.dto.Team;

public class ScoreManagementDb {
	private Team team1 = new Team("Team 1");
	private Team team2 = new Team("Team 2");
	private int team1_playercount = 11;
	private int team2_playercount = 11;
	private int first_match_score;
	private String winning_team;
	private int number_overs = 1;

	private int bowler_number = 10;

	private ScoreBoard board = new ScoreBoard(getBatsmanFromTeam1(), getBatsmanFromTeam1(), team1, team2, getBowler(0),
			0, 0, 0);

	private static ScoreManagementDb scoreManagementDb;

	private ScoreManagementDb() {

	}

	public static ScoreManagementDb getInstance() {
		if (scoreManagementDb == null) {
			scoreManagementDb = new ScoreManagementDb();
		}
		return scoreManagementDb;
	}

	public void swapTeamsInBoard() {
		Team temp = team1;
		team1 = team2;
		team2 = temp;

		bowler_number = 10;

		clearBatsmans();

		board = new ScoreBoard(getBatsmanFromTeam1(), getBatsmanFromTeam1(), team1, team2, getBowler(0), 0, 0, 0);

	}

	public void secondScoreBoard() {
		board.setOver(0);
		bowler_number = 10;

		board = new ScoreBoard(getBatsmanFromTeam2(), getBatsmanFromTeam2(), team2, team1, getBowler(1),
				first_match_score + 1, 0, 0);

	}

	public void clearBatsmans() {
		List<Player> player = team1.getTeam();
		List<Player> player2 = team2.getTeam();

		for (int i = 0; i < player.size(); i++) {
			player.get(i).setBatting_status(true);
			player2.get(i).setBatting_status(true);
		}
	}

	public Team getTeam1() {
		return team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public int getTeam1_playercount() {
		return team1_playercount;
	}

	public int getTeam2_playercount() {
		return team2_playercount;
	}

	public ScoreBoard getBoard() {
		return board;
	}

	public Player getBatsmanFromTeam1() {
		List<Player> players = team1.getTeam();

		Iterator<Player> it = players.iterator();
		Player res = null;

		while (it.hasNext()) {
			Player p1 = it.next();

			if (p1.getBatting_status()) {
				res = p1;
				p1.setBatting_status(false);
				break;
			}
		}
		return res;
	}

	public Player getBatsmanFromTeam2() {
		List<Player> players = team2.getTeam();

		Iterator<Player> it = players.iterator();
		Player res = null;

		while (it.hasNext()) {
			Player p1 = it.next();

			if (p1.getBatting_status()) {
				res = p1;
				p1.setBatting_status(false);
				break;
			}
		}
		return res;
	}

	public int getBowler_number() {
		return bowler_number;
	}

	public void setBowler_number(int bowler_number) {
		this.bowler_number = bowler_number;
	}

	public Player getBowler(int team) {
		if (bowler_number == -1) {
			bowler_number = 10;
		}
		if (team == 1) {
			return team1.getTeam().get(bowler_number--);
		} else {
			return team2.getTeam().get(bowler_number--);
		}
	}

	public int getNumber_overs() {
		return number_overs;
	}

	public void setNumber_overs(int number_overs) {
		this.number_overs = number_overs;
	}

	public int getFirst_match_score() {
		return first_match_score;
	}

	public void setFirst_match_score(int first_match_score) {
		this.first_match_score = first_match_score;
	}

	public String getWinning_team() {
		return winning_team;
	}

	public void setWinning_team(String winning_team) {
		this.winning_team = winning_team;
	}

}
