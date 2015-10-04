package src.com.ser215.main;
public class Player {
	private String name;
	private Hand playerHand;
	
	public Player(String name) {
		this.name = name;
		this.hand = null;
	}
	
	public Player(String name, Hand hand) {
		this.name = name;
		this.hand = hand;
	}
	
	/**
	 * returns the name of the player
	 * @return name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * sets the name of the player
	 * @param name name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * sets the hand of the player
	 * @param hand hand to be set to player
	 */
	public void setHand(Hand hand) {
		this.playerHand = hand;
	}
	
	/**
	 * returns the hand of the player
	 * @return hand of the player
	 */
	public Hand getHand() {
		return this.playerHand;
	}
}
