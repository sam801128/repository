package com.food;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class foodtabledemo extends foodone{
	
	//加載圖片
	    static ImageIcon buttoning = new ImageIcon("buttomdd.png");
		static ImageIcon table = new ImageIcon("table.jpg");
		static ImageIcon floor = new ImageIcon("floor.png");
		static JFrame frame;
		static JFrame frames;
		static JButton c1[] = new JButton[2];       //設定選單用按鈕
		static JButton b1[] ;   //餐廳內部擺設的按鈕
		static String[] tabletotal; //傳入資料庫用
		
  
  public foodtabledemo(){
	  
	  

	  
	  
	  
	  //使用者觀看的擺設視窗
	    frame = new JFrame("餐廳內部座位狀況");
	    frame.setBounds(600, 200, 900, 720);
	    frame.setResizable(false);
	    frame.setAlwaysOnTop(true);//至頂
  	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setUndecorated(true);//不可選取
	    
	    
	    
	    //取得資料庫內的擺設
	    String selecttable = super.selecttable();//取出資料庫內擺設狀況字串
	    newtable newtable = new newtable();
	    tabletotal = newtable.sumtabletotal(selecttable);//將擺設狀況字串轉為陣列儲存運用
		JButton b1[] =  new JButton[tabletotal.length]; //餐廳內部擺設按鈕數量新增
	    
	    
	    //背景
	    foodpanel panel = new foodpanel();

	    //秀出使用者看到擺設狀況
	    int i1 = 0;
	    for(int i=0;i < tabletotal.length;i++)
	      {
	            if(i%16==0 && i!=0)
	    	    {i1 = i1 + 1;}
	    		b1[i] = new JButton();
	    	    b1[i].setBounds(50+((i%16)*50), (i1*50)+100 , 50, 50);
	    	       if(tabletotal[i].equals("0"))//資料庫內位置為0設定為地板
	    	         b1[i].setIcon(floor);
	    	       else if(tabletotal[i].equals("1"))//資料庫內位置為1設定為座位
	    	    	 b1[i].setIcon(table);
	    	    b1[i].setActionCommand(String.valueOf(i));
	    	    frame.add(b1[i]);	  
	     }
	    frame.add(panel);
	    frame.setVisible(true);
	  
	  
	  
	  
	  
  }
  
}

