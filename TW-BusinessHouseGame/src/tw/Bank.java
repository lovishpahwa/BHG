package tw;

public class Bank {

	private int balance = 5000;

	public int getBalance() {
		return this.balance;
	}
	
	public void addMoney(int amount) {
		this.balance += amount;
	}
	
	public void deductMoney(int amount) {
		this.balance -= amount;
	}

}
