package com.ser215.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class TablePanel extends JPanel {
	BufferedImage spadeA;
	BufferedImage heartK;
	BufferedImage back;
	
	public TablePanel() {
		setBackground(new Color(0, 153, 51));
		/*try {
			club2 = ImageIO.read(new File("2club.jpg"));
		} catch (IOException e) {
			
		}*/
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			spadeA = ImageIO.read(new File("/Users/rbeerma/workspace-school/FinalProject/images/spadeA.jpg"));
			heartK = ImageIO.read(new File("/Users/rbeerma/workspace-school/FinalProject/images/heartK.jpg"));
			back = ImageIO.read(new File("/Users/rbeerma/workspace-school/FinalProject/images/back.jpg"));
		} catch (IOException e) {
			
		}
		g.drawImage(spadeA, 50, 50, null);
		g.drawImage(heartK, 85, 50, null);
		g.drawImage(back, 85, 50, null);
	}
}