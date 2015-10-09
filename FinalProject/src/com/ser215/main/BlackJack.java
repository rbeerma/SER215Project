package com.ser215.main;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Component;
import javax.swing.SwingConstants;

public class BlackJack {

	private JFrame frame;
	private Dealer dealer;
	private Player player;
	private DecimalFormat df = new DecimalFormat("#.00");
	public static GameState gameState;
	
	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState newState) {
		gameState = newState;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackJack window = new BlackJack();
					window.frame.setLocationRelativeTo(null);
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
		gameState = GameState.INIT;
		player = new Player("Player");
		dealer = new Dealer();
		Deck deck = new Deck();
		Hand playerHand1 = new Hand();
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
		btnClearBet.setBounds(20, 273, 120, 44);
		btnClearBet.setEnabled(false);
						
		JButton btnBet25 = new JButton("Bet $25");
		btnBet25.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBet25.setBounds(20, 75, 120, 44);
		btnBet25.setEnabled(true);
						
		JButton btnBet50 = new JButton("Bet $50");
		btnBet50.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBet50.setBounds(20, 132, 120, 44);
		btnBet50.setEnabled(true);
				
		JButton btnBet100 = new JButton("Bet $100");
		btnBet100.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBet100.setBounds(20, 189, 120, 44);
		btnBet100.setEnabled(true);
			
		JButton btnHit = new JButton("Hit");
		btnHit.setBounds(231, 20, 120, 44);
		btnHit.setEnabled(false);
				
		JButton btnStand = new JButton("Stand");
		btnStand.setBounds(494, 20, 120, 44);
		btnStand.setEnabled(false);
		
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
		
		JLabel lblDealerHand = new JLabel("Dealer Showing:");
		lblDealerHand.setBounds(12, 13, 100, 16);
		bottomPanel.add(lblDealerHand);
		
		JLabel lblPlayerValue = new JLabel("");
		lblPlayerValue.setBounds(119, 42, 56, 16);
		bottomPanel.add(lblPlayerValue);
		
		JLabel lblDealerValue = new JLabel("");
		lblDealerValue.setBounds(119, 13, 56, 16);
		bottomPanel.add(lblDealerValue);
		
		// build the right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		rightPanel.setBounds(820, 0, 194, 505);
		frame.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);
		
		//build the labels and buttons
		JLabel lblBank = new JLabel("Bank:  $");
		lblBank.setBounds(20, 22, 51, 16);
		
		rightPanel.add(lblBank);
		
		JLabel lblBalance = new JLabel(String.valueOf(df.format(bank.getBalance())));
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setBounds(72, 22, 79, 16);
		
		rightPanel.add(lblBalance);
		
		JLabel lblBet = new JLabel("Bet:  $");
		lblBet.setBounds(20, 46, 120, 16);
		rightPanel.add(lblBet);
		
		JLabel lblBetAmt = new JLabel(String.valueOf(df.format(bank.getCurrentBet())));
		lblBetAmt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBetAmt.setBounds(72, 46, 79, 16);
		rightPanel.add(lblBetAmt);
		
		rightPanel.add(btnBet25);
		rightPanel.add(btnBet50);
		rightPanel.add(btnBet100);
		rightPanel.add(btnDeal);
		rightPanel.add(btnClearBet);
		
		TablePanel tablePanel = new TablePanel();
		tablePanel.setBounds(0, 0, 820, 420);
		frame.getContentPane().add(tablePanel);
		
		// build an option dialog to show when each hand is complete
		JOptionPane optionPane = new JOptionPane(JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		Object[] options = new String[] {"Yes", "No"};
		optionPane.setOptions(options);
		JDialog dialog = optionPane.createDialog(new JFrame(), "What next?");
		dialog.setBounds(0, 0, 400, 150);
		dialog.setContentPane(optionPane);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(false);
		dialog.setLocationRelativeTo(null);
				
		/* Button Listeners
		*  The majority of the game logic should be encapsulated in these listeners,
		*  within the actionPerformed() methods.
		*/
		btnDeal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Clear the previous hand, if any
				playerHand1.clear();
				dealerHand.clear();
				
				gameState = GameState.PLAYER_ACT;
				// Make bet buttons unavailable
				btnBet25.setEnabled(false);
				btnBet50.setEnabled(false);
				btnBet100.setEnabled(false);
				btnClearBet.setEnabled(false);
				btnDeal.setEnabled(false);
				
				playerHand1.addCard(deck.getNextCard());
				dealerHand.addCard(deck.getNextCard());
				dealer.setShowingCard(dealerHand.getCards().get(0));
				playerHand1.addCard(deck.getNextCard());
				playerHand1.updateValue();
				dealerHand.addCard(deck.getNextCard());
				dealerHand.setShowHoleCard(false);
				
				player.setPlayerHand1(playerHand1);
				dealer.setHand(dealerHand);
				lblPlayerValue.setText(String.valueOf(playerHand1.getTotalValue()));
				
				// ***** comment out the next line after testing *****
				lblDealerValue.setText(String.valueOf(dealer.getShowingCard().getValue()));
				
				if (playerHand1.getTotalValue() == 21) {
					
					if (dealerHand.getTotalValue() == 21){
						//If dealer is showing 10 and has blackjack, player is paid, payout even
						
						dealerHand.setShowHoleCard(true);
						bank.payoutPush();
						bank.clearBet();
						gameState = GameState.PUSH;
						lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
						lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
						
						//Enable betting buttons, all other buttons disabled
						if (bank.getBalance() >= 25) {
							btnBet25.setEnabled(true);
						}
						if (bank.getBalance() >= 50) {
							btnBet50.setEnabled(true);
						}
						if (bank.getBalance() >= 100) {
							btnBet100.setEnabled(true);
						}
						btnClearBet.setEnabled(true);

						btnDeal.setEnabled(false);
						btnHit.setEnabled(false);
						btnStand.setEnabled(false);
					} else {
						dealerHand.setShowHoleCard(true);
						
						// Player has blackjack, dealer doesn't, payout for blackjack
						bank.payoutBlackjack();
						bank.clearBet();
						lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
						lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
						gameState = GameState.BLACKJACK;
						
						//Enable betting buttons, all other buttons disabled
						if (bank.getBalance() >= 25) {
							btnBet25.setEnabled(true);
						}
						if (bank.getBalance() >= 50) {
							btnBet50.setEnabled(true);
						}
						if (bank.getBalance() >= 100) {
							btnBet100.setEnabled(true);
						}
						btnClearBet.setEnabled(true);

						btnDeal.setEnabled(false);
						btnHit.setEnabled(false);
						btnStand.setEnabled(false);
					}
				} else {

					if (dealerHand.getTotalValue() == 21){
						//If dealer is showing 10 and has blackjack, end turn.
						
						dealerHand.setShowHoleCard(true);
						gameState = GameState.DEALER_WIN;
						//Enable betting buttons, all other buttons disabled
						if (bank.getBalance() >= 25) {
							btnBet25.setEnabled(true);
						}
						if (bank.getBalance() >= 50) {
							btnBet50.setEnabled(true);
						}
						if (bank.getBalance() >= 100) {
							btnBet100.setEnabled(true);
						}
						btnClearBet.setEnabled(true);
						btnDeal.setEnabled(false);
						btnHit.setEnabled(false);
						btnStand.setEnabled(false);
					} else {
						// Allow hit, stand, double
						
						btnHit.setEnabled(true);
						btnStand.setEnabled(true);
					}
				}
				
				// use this block to update and show dialog after each hand. Change message based on hand result.
				if (gameState == GameState.PLAYER_BUST || gameState == GameState.PLAYER_WIN || gameState == GameState.DEALER_WIN
						|| gameState == GameState.PUSH || gameState == GameState.BLACKJACK) {
					optionPane.setMessage(getMessage(gameState));
					dialog.setVisible(true);
					String selection = (String)optionPane.getValue();
										
					if (selection == "Yes") {
						playerHand1.clear();
						dealerHand.clear();
						bank.clearBet();
						lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
						dealerHand.setShowHoleCard(true);
					} else if (selection == null || selection == "No") {
						frame.dispose();
					}
				}
				// end dialog block
				
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
				lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
			}
			
		});
		
		btnBet25.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameState = GameState.BETTING;
				btnDeal.setEnabled(true);
				btnClearBet.setEnabled(true);
				bank.increaseBet(25);
				
				// disable betting buttons if they've hit the limit or don't have enough money
				if (bank.getBalance() < 25 || bank.getCurrentBet()+25 > Bank.MAX_BET) {
					btnBet25.setEnabled(false);
				}
				if (bank.getBalance() < 50 || bank.getCurrentBet()+50 > Bank.MAX_BET) {
					btnBet50.setEnabled(false);
				}
				if (bank.getBalance() < 100 || bank.getCurrentBet()+100 > Bank.MAX_BET) {
					btnBet100.setEnabled(false);
				}
				
				lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
				lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
			}
			
		});
		
		btnBet50.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameState = GameState.BETTING;
				btnDeal.setEnabled(true);
				btnClearBet.setEnabled(true);
				bank.increaseBet(50);
				
				// disable betting buttons if they've hit the limit or don't have enough money
				if (bank.getBalance() < 25 || bank.getCurrentBet()+25 > Bank.MAX_BET) {
					btnBet25.setEnabled(false);
				}
				if (bank.getBalance() < 50 || bank.getCurrentBet()+50 > Bank.MAX_BET) {
					btnBet50.setEnabled(false);
				}
				if (bank.getBalance() < 100 || bank.getCurrentBet()+100 > Bank.MAX_BET) {
					btnBet100.setEnabled(false);
				}
				
				lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
				lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
			}
			
		});
		
		btnBet100.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameState = GameState.BETTING;
				btnDeal.setEnabled(true);
				btnClearBet.setEnabled(true);
				bank.increaseBet(100);
				
				// disable betting buttons if they've hit the limit or don't have enough money
				if (bank.getBalance() < 25 || bank.getCurrentBet()+25 > Bank.MAX_BET) {
					btnBet25.setEnabled(false);
				}
				if (bank.getBalance() < 50 || bank.getCurrentBet()+50 > Bank.MAX_BET) {
					btnBet50.setEnabled(false);
				}
				if (bank.getBalance() < 100 || bank.getCurrentBet()+100 > Bank.MAX_BET) {
					btnBet100.setEnabled(false);
				}
				
				lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
				lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
			}
			
		});
		
		btnHit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameState = GameState.PLAYER_ACT;
				// Add card to player's hand
				playerHand1.addCard(deck.getNextCard());
				playerHand1.updateValue();
				lblPlayerValue.setText(String.valueOf(playerHand1.getTotalValue()));
				
				if (playerHand1.getTotalValue() == 21) {
					// If player has 21, make all other play buttons except 
					// Stand unavailable.
					btnHit.setEnabled(false);
					btnStand.setEnabled(true);
					//gameState = GameState.PLAYER_WIN;
					
				} else if (playerHand1.getTotalValue() > 21){
					// if player has busted, allow betting
					bank.clearBet();
					lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
					
					if (bank.getBalance() >= 25) {
						btnBet25.setEnabled(true);
					}
					if (bank.getBalance() >= 50) {
						btnBet50.setEnabled(true);
					}
					if (bank.getBalance() >= 100) {
						btnBet100.setEnabled(true);
					}
					btnClearBet.setEnabled(true);

					btnDeal.setEnabled(false);
					btnHit.setEnabled(false);
					btnStand.setEnabled(false);
					
					gameState = GameState.PLAYER_BUST;
				} else {
					// else allow hit or stand, NOT Split or Double
					btnHit.setEnabled(true);
					btnStand.setEnabled(true);
				}
				
				// use this block to update and show dialog after each hand. Change message based on hand result.
				if (gameState == GameState.PLAYER_BUST || gameState == GameState.PLAYER_WIN || gameState == GameState.DEALER_WIN || gameState == GameState.PUSH) {
					optionPane.setMessage(getMessage(gameState));
					dialog.setVisible(true);
					String selection = (String)optionPane.getValue();
										
					if (selection == "Yes") {
						bank.clearBet();
						playerHand1.clear();
						dealerHand.clear();
						lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
						dealerHand.setShowHoleCard(true);
					} else if (selection == null || selection == "No") {
						frame.dispose();
					}
				}
				// end dialog block
			}
			
		});
		
		btnStand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gameState = GameState.DEALER_ACT;
				//  Show hole card.
				dealerHand.setShowHoleCard(true);
				
				boolean dealerDrawing = true;
				
				while(dealerDrawing){
					//Dealer draws until hand value >= 17
					if(dealerHand.getTotalValue() >= 17 || (dealerHand.hasAce() && dealerHand.getTotalValue() >=18)){
						dealerDrawing = false;
					}
					else{
						dealerHand.addCard(deck.getNextCard());
						lblDealerValue.setText(String.valueOf(dealerHand.getTotalValue()));
					}
				}
				
				if(dealerHand.getTotalValue() > playerHand1.getTotalValue() && dealerHand.getTotalValue() < 21) {
					//bank.payoutPush();
					lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
					gameState = GameState.DEALER_WIN;
				}

				if(dealerHand.getTotalValue() == playerHand1.getTotalValue()){
					bank.payoutPush();
					lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
					gameState = GameState.PUSH;
				}
				
				if(dealerHand.getTotalValue() < playerHand1.getTotalValue() || dealerHand.getTotalValue() > 21){
					bank.payoutWin();
					lblBalance.setText(String.valueOf(df.format(bank.getBalance())));
					gameState = GameState.PLAYER_WIN;
				}

				bank.clearBet();
				lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
				
				// Bet buttons available, all others unavailable
				if (bank.getBalance() >= 25) {
					btnBet25.setEnabled(true);
				}
				if (bank.getBalance() >= 50) {
					btnBet50.setEnabled(true);
				}
				if (bank.getBalance() >= 100) {
					btnBet100.setEnabled(true);
				}
				btnClearBet.setEnabled(true);

				btnDeal.setEnabled(false);
				btnHit.setEnabled(false);
				btnStand.setEnabled(false);
				
				// use this block to update and show dialog after each hand. Change message based on hand result.
				if (gameState == GameState.PLAYER_BUST || gameState == GameState.DEALER_WIN || gameState == GameState.PLAYER_WIN || gameState == GameState.PUSH || gameState == GameState.BLACKJACK) {
					optionPane.setMessage(getMessage(gameState));
					dialog.setVisible(true);
					String selection = (String)optionPane.getValue();
										
					if (selection == "Yes") {
						bank.clearBet();
						playerHand1.clear();
						dealerHand.clear();
						lblBetAmt.setText(String.valueOf(df.format(bank.getCurrentBet())));
						dealerHand.setShowHoleCard(true);
					} else if (selection == null || selection == "No") {
						frame.dispose();
					}
				}
				// end dialog block
			}
			
		});
		
		// end button listeners
	}
	
	public String assessHands() {
		return "";
	}
	
	// This method returns an appropriate message given the current game state.
	// More states can be added to the GameState enum as needed to add other messages.
	public String getMessage(GameState gameState) {
		String msg = "";
		
		switch(gameState) {
			case PLAYER_BUST: msg = "You busted. Keep playing?";
				break;
			case PLAYER_WIN: msg = "You win! Keep playing?";
				break;
			case DEALER_WIN: msg = "Dealer wins. Keep playing?";
				break;
			case BANK_EMPTY: msg = "You're out of money. Want to start again?";
				break;
			case PUSH: msg = "The hand is a push! Keep playing?";
				break;
			case BLACKJACK: msg = "You got blackjack! Keep playing?";
				break;
			default: msg = "";
		}
		
		return msg;
	}
}
