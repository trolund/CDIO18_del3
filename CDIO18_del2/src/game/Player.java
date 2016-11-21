package game;

public class Player {
	
	private String name;
	private BankAccount account;
	private boolean bankrupt = false;
	private int carPos = 0;
	
	public Player(int balance, String name) {
		this.name = name;
		account = new BankAccount(balance);
	}	
	
	
	public BankAccount getAccount() {
		return account;
	}

	public String getName() {
		return name;
	}


	public boolean getBankruptStatus() {
		return bankrupt;
	}


	public void setBankrupt(boolean bankrupt) {
		this.bankrupt = bankrupt;
	}


	public int getCarPos() {
		return carPos;
	}


	public void setCarPos(int carPos) {
		this.carPos = carPos;
	}
	
	public void moveCarPos(int carPos) {
		this.carPos += carPos;
	}

}
