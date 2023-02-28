package secondbatting;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.ScoreBoard;

public interface SecondModelCallBack {

	String getTeam2name();

	ScoreBoard getScoreBoard();

	Player getBatsman();

	Player getabowler();

	boolean isTeam2Out(int score);

	int getpreviousScore();

	void setwinneras(String winner);


}
