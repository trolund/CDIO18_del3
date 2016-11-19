package game;

public class Player {
	
	private String name;
	private BankAccount account;
	private boolean bankrupt = false;
	
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
	
	

}
