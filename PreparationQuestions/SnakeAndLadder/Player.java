package PreparationQuestions.SnakeAndLadder;

public class Player {

	private static int count;

	private String name;
	private int position;
	private String nickName;

	public Player(String name) {
		this.name = name;
		nickName = "P" + ++count;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public String getNickName() {
		return nickName;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		System.out.println(name + " (" + nickName + ")  Position :  " + position);
		return "";
	}

}
