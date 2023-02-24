package firstbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

public interface FirstMatchModelCallBack {

	String getTeam1name();

	ScoreBoard getScoreBoard();

	boolean isTeam1Out();

	Player getBatsman();

	Player getabowler();

	void setMatch1Score(int score);

	void setwinner(String winner);

}
