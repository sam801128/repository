package com.food;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class foodpanel extends JPanel {
	//加載所有圖片
    ImageIcon title = new ImageIcon("title.png");

	public void paint(Graphics g){
		//設置畫布背景顏色
		 this.setBackground(Color.BLACK);
		 g.fillRect(25, 75, 850, 600);
		//設置標題
		 title.paintIcon(this,g,25,11);
		 //
         
	}
	
}
