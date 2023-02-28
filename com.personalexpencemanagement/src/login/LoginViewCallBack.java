package login;

public interface LoginViewCallBack {

	void improperUser(String error);

	void dailyCalculationFailed(String error);

	void dailyCalculatorResult(String message, double amountcanspendforoneday);

	void UserCreatedSuccessfully(String name, int pin);

	void loginSuccess();

	void invalidAmount();

	void resetFailed(String error);

}
