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
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}