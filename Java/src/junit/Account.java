package junit;

public class Account {
	private double moneyAmount;

	public double getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	
	public Account() {
		
	}
	public Account(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

}
