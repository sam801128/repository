package com.food;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class foodpanel extends JPanel {
	//�[���Ҧ��Ϥ�
    ImageIcon title = new ImageIcon("title.png");

	public void paint(Graphics g){
		//�]�m�e���I���C��
		 this.setBackground(Color.BLACK);
		 g.fillRect(25, 75, 850, 600);
		//�]�m���D
		 title.paintIcon(this,g,25,11);
		 //
         
	}
	
}
