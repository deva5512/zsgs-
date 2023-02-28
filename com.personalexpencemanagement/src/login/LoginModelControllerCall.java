package login;

public interface LoginModelControllerCall {

	void improperUser(String error);

	void UserCreatedSuccessfully(String name, int pin);

	void loginSuccess();

	void invalidAmount();

	void resetFailed(String error);

}
