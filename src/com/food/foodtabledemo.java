package com.food;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class foodtabledemo extends foodone{
	
	//�[���Ϥ�
	    static ImageIcon buttoning = new ImageIcon("buttomdd.png");
		static ImageIcon table = new ImageIcon("table.jpg");
		static ImageIcon floor = new ImageIcon("floor.png");
		static JFrame frame;
		static JFrame frames;
		static JButton c1[] = new JButton[2];       //�]�w���Ϋ��s
		static JButton b1[] ;   //�\�U�����\�]�����s
		static String[] tabletotal; //�ǤJ��Ʈw��
		
  
  public foodtabledemo(){
	  
	  

	  
	  
	  
	  //�ϥΪ��[�ݪ��\�]����
	    frame = new JFrame("�\�U�����y�쪬�p");
	    frame.setBounds(600, 200, 900, 720);
	    frame.setResizable(false);
	    frame.setAlwaysOnTop(true);//�ܳ�
  	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setUndecorated(true);//���i���
	    
	    
	    
	    //���o��Ʈw�����\�]
	    String selecttable = super.selecttable();//���X��Ʈw���\�]���p�r��
	    newtable newtable = new newtable();
	    tabletotal = newtable.sumtabletotal(selecttable);//�N�\�]���p�r���ର�}�C�x�s�B��
		JButton b1[] =  new JButton[tabletotal.length]; //�\�U�����\�]���s�ƶq�s�W
	    
	    
	    //�I��
	    foodpanel panel = new foodpanel();

	    //�q�X�ϥΪ̬ݨ��\�]���p
	    int i1 = 0;
	    for(int i=0;i < tabletotal.length;i++)
	      {
	            if(i%16==0 && i!=0)
	    	    {i1 = i1 + 1;}
	    		b1[i] = new JButton();
	    	    b1[i].setBounds(50+((i%16)*50), (i1*50)+100 , 50, 50);
	    	       if(tabletotal[i].equals("0"))//��Ʈw����m��0�]�w���a�O
	    	         b1[i].setIcon(floor);
	    	       else if(tabletotal[i].equals("1"))//��Ʈw����m��1�]�w���y��
	    	    	 b1[i].setIcon(table);
	    	    b1[i].setActionCommand(String.valueOf(i));
	    	    frame.add(b1[i]);	  
	     }
	    frame.add(panel);
	    frame.setVisible(true);
	  
	  
	  
	  
	  
  }
  
}

