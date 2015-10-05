package com.ser215.main;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Component;

public class BlackJack {

	private JFrame frame;
	Dealer dealer;
	Player player;
	DecimalFormat df = new DecimalFormat("#.00");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJack window = new BlackJack();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BlackJack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		player = new Player("Player");
		dealer = new Dealer();
		Deck deck = new Deck();
		Hand playerHand1 = new Hand();
		Hand playerHand2 = new Hand();
		Hand dealerHand = new Hand();
		Bank bank = new Bank();
		bank.setBalance(1000.00);
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1020, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Setup all buttons and initialize their enabled state
		JButton btnDeal = new JButton("Deal");
		btnDeal.setBounds(20, 330, 120, 88);
		btnDeal.setEnabled(false);
				
		JButton btnClearBet = new JButton("Clear Bet");
		btnClearBet.setBounds(20, 248, 120, 44);
		btnClearBet.setEnabled(false);
						
		JButton btnBet25 = new JButton("Bet $25");
		btnBet25.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBet25.setBounds(20, 51, 120, 44);
		btnBet25.setEnabled(true);
						
		JButton btnBet50 = new JButton("Bet $50");
		btnBet50.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBet50.setBounds(20, 110, 120, 44);
		btnBet50.setEnabled(true);
				
		JButton btnBet100 = new JButton("Bet $100");
		btnBet100.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBet100.setBounds(20, 167, 120, 44);
		btnBet100.setEnabled(true);
			
		JButton btnHit = new JButton("Hit");
		btnHit.setBounds(231, 20, 120, 44);
		btnHit.setEnabled(false);
				
		JButton btnStand = new JButton("Stand");
		btnStand.setBounds(494, 20, 120, 44);
		btnStand.setEnabled(false);
		
		// Removing these buttons for now
		
		/*JButton btnSplit = new JButton("Split");
		btnSplit.setBounds(348, 20, 120, 44);
		btnSplit.setEnabled(false);
		
		JButton btnDouble = new JButton("Double");
		btnDouble.setBounds(504, 20, 120, 44);
		btnDouble.setEnabled(false);
		
		JButton btnBuyInsurance = new JButton("Buy Insurance");
		btnBuyInsurance.setBounds(660, 20, 120, 44);
		btnBuyInsurance.setEnabled(false);*/
		// end button definitions
		
		// build the bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		bottomPanel.setBounds(0, 421, 1014, 84);
		frame.getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		/* add buttons to the bottom panel
		*  their locations are specified in their setBounds() method,
		*  where the first two parameters are the x and y coordinates 
		*  relative to the containing panel
		*/
		bottomPanel.add(btnHit);
		bottomPanel.add(btnStand);
		
		JLabel lblPlayerHand = new JLabel("Player Hand:");
		lblPlayerHand.setBounds(12, 42, 81, 16);
		bottomPanel.add(lblPlayerHand);
		
		JLabel lblDealerHand = new JLabel("Dealer Hand:");
		lblDealerHand.setBounds(12, 13, 81, 16);
		bottomPanel.add(lblDealerHand);
		
		JLabel lblPlayerValue = new JLabel("");
		lblPlayerValue.setBounds(119, 42, 56, 16);
		bottomPanel.add(lblPlayerValue);
		
		JLabel lblDealerValue = new JLabel("");
		lblDealerValue.setBounds(119, 13, 56, 16);
		bottomPanel.add(lblDealerValue);
		//bottomPanel.add(btnSplit);
		//bottomPanel.add(btnDouble);
		//bottomPanel.add(btnBuyInsurance);
		
		// build the right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rightPanel.setBounds(820, 0, 194, 505);
		frame.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);
		
		//build the 
		JLabel lblBank = new JLabel("Bank:  $");
		lblBank.setBounds(20, 22, 51, 16);
		
		rightPanel.add(lblBank);
		
		JLabel lblBalance = new JLabel(String.valueOf(df.format(bank.getBalance())));
		lblBalance.setBounds(72, 22, 79, 16);
		
		rightPanel.add(lblBalance);
		rightPanel.add(btnBet25);
		rightPanel.add(btnBet50);
		rightPanel.add(btnBet100);
		rightPanel.add(btnDeal);
		rightPanel.add(btnClearBet);
		
		TablePanel tablePanel = new TablePanel();
		tablePanel.setBounds(0, 0, 820, 420);
		frame.getContentPane().add(tablePanel);
				
		/* Button Listeners
		*  The majority of the game logic should be encapsulated in these listeners,
		*  within the actionPerformed() methods.
		*/
		btnDeal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Make bet buttons unavailable
				btnBet25.setEnabled(false);
				btnBet50.setEnabled(false);
				btnBet100.setEnabled(false);
				btnClearBet.setEnabled(false);
				btnDeal.setEnabled(false);
				
				//dealer.clearTable();
				//dealer.fillHand();
				
				playerHand1.addCard(deck.getNextCard());
				dealerHand.addCard(deck.getNextCard());
				dealer.setShowingCard(dealerHand.getCards().get(0));
				playerHand1.addCard(deck.getNextCard());
				dealerHand.addCard(deck.getNextCard());
				
				player.setPlayerHand1(playerHand1);
				dealer.setHand(dealerHand);
				lblPlayerValue.setText(String.valueOf(playerHand1.getTotalValue()));
				lblDealerValue.setText(String.valueOf(dealerHand.getTotalValue()));
				
				Deck.cardsDealt = true;
				
				if (playerHand1.getTotalValue() == 21){
					//If Player Has blackjack...
					
					if (dealer.getShowingCard().getPipValue() == 0){
						// TODO: Offer Insurance -- need a way for this to be resolved and then
						// return back...
					}
					if (dealer.getShowingCard().getValue() == 10 && dealerHand.getTotalValue() == 21){
						//If dealer is showing 10 and has blackjack, player is paid, payout even
						
						// TODO: Show Hole Card
						//playerBank.payoutEven();
					}
					else{
						// TODO: Show Hole Card
						
						// Player has blackjack, dealer doesn't, payout for blackjack
						
						//playerBank.payoutBlackjack();
						
						//Enable betting buttons, all other buttons disabled
						btnBet25.setEnabled(true);
						btnBet50.setEnabled(true);
						btnBet100.setEnabled(true);
						btnClearBet.setEnabled(true);

						btnDeal.setEnabled(false);
						btnHit.setEnabled(false);
						btnStand.setEnabled(false);
						//btnSplit.setEnabled(false);
						//btnDouble.setEnabled(false);
						//btnBuyInsurance.setEnabled(false);
					}
				}
				
				else{
					//If Player doesn't have blackjack...
					if (dealer.getShowingCard().getPipValue() == 0){
						// TODO: Offer Insurance -- need a way for this to be resolved and then
						// return back...
					}
					if (dealer.getShowingCard().getValue() == 10 && dealerHand.getTotalValue() == 21){
						//If dealer is showing 10 and has blackjack, end turn.
						
						// TODO: Show Hole Card
						
						//Enable betting buttons, all other buttons disabled
						btnBet25.setEnabled(true);
						btnBet50.setEnabled(true);
						btnBet100.setEnabled(true);
						btnClearBet.setEnabled(true);

						btnDeal.setEnabled(false);
						btnHit.setEnabled(false);
						btnStand.setEnabled(false);
						//btnSplit.setEnabled(false);
						//btnDouble.setEnabled(false);
						//btnBuyInsurance.setEnabled(false);
					}
					else{
						if(playerHand1.getCards().get(0).getValue() == playerHand1.getCards().get(1).getValue()){
							// Allow split if first two cards have equal value
							//btnSplit.setEnabled(true);
						}
						
						// Allow hit, stand, double
						
						btnHit.setEnabled(true);
						btnStand.setEnabled(true);
						//btnDouble.setEnabled(true);
					}
				}
				
			}
			
			
		});
		
		btnClearBet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnClearBet.setEnabled(false);
				btnDeal.setEnabled(false);
				bank.setBalance(bank.getBalance() + bank.getCurrentBet());
				bank.setCurrentBet(0.00);
				
				lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
			}
			
		});
		
		btnBet25.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeal.setEnabled(true);
				btnClearBet.setEnabled(true);
				bank.increaseBet(25);
				//if (bank.getCurrentBet())
				
				lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
			}
			
		});
		
		btnBet50.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeal.setEnabled(true);
				btnClearBet.setEnabled(true);
				bank.increaseBet(50);
				
				lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
				
			}
			
		});
		
		btnBet100.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeal.setEnabled(true);
				btnClearBet.setEnabled(true);
				bank.increaseBet(100);
				
				lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
				
			}
			
		});
		
		btnHit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Add card to player's hand
				playerHand1.addCard(deck.getNextCard());
				playerHand1.updateValue();
				lblPlayerValue.setText(String.valueOf(playerHand1.getTotalValue()));
				
				if(playerHand1.getTotalValue() == 21){
					// If player has blackjack, make all other play buttons except 
					// Stand unavailable.
					btnDeal.setEnabled(false);
					btnHit.setEnabled(false);
					//btnSplit.setEnabled(false);
					//btnDouble.setEnabled(false);
					//btnBuyInsurance.setEnabled(false);
				}
				if(playerHand1.getTotalValue() > 21){
					// if player has busted, go to bet phase.
					//betPhase();
				}
				else{
					// else allow hit or stand, NOT Split or Double
					btnHit.setEnabled(true);
					btnStand.setEnabled(true);
					//btnSplit.setEnabled(false);
					//btnDouble.setEnabled(false);
				}
			}
			
		});
		
		btnStand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		/*btnSplit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});*/
		// end button listeners
	}
	
	public String assessHands() {
		return "";
	}
}
