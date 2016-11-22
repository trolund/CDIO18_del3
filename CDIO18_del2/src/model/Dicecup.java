package model;

public class Dicecup {

	public Die die1 = new Die();
	public Die die2 = new Die();

	public int getSum(){
		return die1.getValue() + die2.getValue(); 

	}
}
