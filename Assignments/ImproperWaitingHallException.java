package StackAndQueue;

public class ImproperWaitingHallException extends Exception {
	@Override
	public String getMessage() {
		return "Waiting hall count cant able to be Greater then total count ";
	}
}
