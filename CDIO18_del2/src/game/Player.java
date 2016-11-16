package game;

public class Player {
	
	private String name;
	private BankAccount account;
	
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

}
