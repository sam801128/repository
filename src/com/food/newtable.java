package com.food;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public  class newtable  extends foodone{
	


	//加載圖片
	static ImageIcon buttoning = new ImageIcon("buttomdd.png");
	static ImageIcon table = new ImageIcon("table.jpg");
	static ImageIcon floor = new ImageIcon("floor.png");
	static JFrame frame;
	static JFrame frames;
	static JButton c1[] = new JButton[2];       //設定選單用按鈕
	static JButton b1[] ;   //餐廳內部擺設按鈕
	static String[] tabletotal; //傳入資料庫用
	
	
	public newtable(){
		
	}

	
	public  newtable(int a){

	JButton b1[] =  new JButton[a]; //餐廳內部擺設按鈕
	String tabletotal[] = new String[a]; //傳入資料庫用
	for(int i = 0 ; i < tabletotal.length ; i++) //將talbletotal陣列內值接設定為0
	   {
		tabletotal[i] = "0";
	   }
   //新增餐廳內部座位的框架
    frame = new JFrame("餐廳內部座位狀況");
    frame.setBounds(350, 200, 900, 720);
    frame.setResizable(false);
    frame.setAlwaysOnTop(true);//至頂
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setUndecorated(true);
    
    
   //新增座位設定選單框架
    frames = new JFrame("設定選單");
    frames.setBounds(1250, 200, 306, 179);
    frames.setResizable(false);//不可讓用戶調整視窗大小
    frames.setAlwaysOnTop(true);//至頂
    frames.setLayout(null);
    frames.setUndecorated(true);



   
 
    //新增座位設定選單按鈕  與 按鈕事件
    c1[0] = new JButton("確定送出");
    c1[1] = new JButton("離開");
    c1[0].setBounds(0, 0, 150, 150);
    c1[1].setBounds(150, 0, 150, 150);
    c1[0].addActionListener(new ActionListener() //送出按鈕的事件
       {
         public void actionPerformed(ActionEvent e) 
           {
        	   frame.setAlwaysOnTop(false);
        	   frames.setAlwaysOnTop(false);
         	   int n = JOptionPane.showConfirmDialog(null, "確定將目前擺設儲存", "設定確認",JOptionPane.YES_NO_OPTION); //返回值為0或1
	               if(n==0)
	               {
  	                   System.out.println("確認設定儲存");
  	                   String sumtabletotalStr = sumtabletotal(tabletotal);  //將桌位陣列轉成字串並用String接收
  	                   inputable(sumtabletotalStr);//將值傳入資料庫
	               }
	               else if(n==1)
	               {
	                   System.out.println("已取消");
	               }
           }
       });
    c1[1].addActionListener(new ActionListener() //離開按鈕的事件
      {
         public void actionPerformed(ActionEvent e) 
           {
    	       System.exit(0);
           }
      });
    frames.add(c1[0]);
    frames.add(c1[1]);
    frames.setVisible(true);

    
 
    
    
    // c1[0].setMnemonic(KeyEvent.VK_D); 綁定按鈕ALT+D
   
    
  //新增座位擺設按鈕，依框架每16個換行
    foodpanel panel = new foodpanel();

    

    int i1 = 0;
    for(int i=0;i < a;i++){
    	if(i%16==0 && i!=0){
    		i1 = i1 + 1;
    	}
    		b1[i] = new JButton();
    	    b1[i].setBounds(50+((i%16)*50), (i1*50)+100 , 50, 50);
    	    b1[i].setIcon(floor);
    	    b1[i].setActionCommand(String.valueOf(i));
    	    b1[i].addActionListener(new ActionListener() //設定為座位的按鈕事件
    	    {
    	     public void actionPerformed(ActionEvent e) {
    	        
    	        	String c2 = e.getActionCommand();
    	        	int a2 = Integer.parseInt(c2);
    	        	b1[a2].setIcon(buttoning);
    	        	frame.setAlwaysOnTop(false);
    	        	 	        	
    	        	Object[] options ={"桌位", "走道"};
    	        	int setoption = JOptionPane.showOptionDialog(null, "將此空格設定為", "設定",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, buttoning , options, options[0]); 
                    
    	        	if(setoption == 0){
    	                //int n = JOptionPane.showConfirmDialog(null, "確定設定為餐桌", "設定確認",JOptionPane.YES_NO_OPTION); //返回值為0或1
    	                    frame.setAlwaysOnTop(true);
    	                    frame.setEnabled(true);
    	                    b1[a2].setIcon(table);
    	                    tabletotal[a2] = "1";
                    }else if(setoption == 1){
     	                    frame.setAlwaysOnTop(true);
     	                    frame.setEnabled(true);
     	                    b1[a2].setIcon(floor);
     	                    tabletotal[a2] = "0";
                    }else{
                    	    frame.setAlwaysOnTop(true);
 	                        frame.setEnabled(true);
 	                        b1[a2].setIcon(floor);
 	                        tabletotal[a2] = "0";
                    }
       	                                                 }
    	     }); 

    	frame.add(b1[i]);	  
    }
    

    
    //添加畫筆，用來設定背景圖片
     frame.add(panel);
     frame.setVisible(true);


	    }
	
     public String sumtabletotal(String[] tabletotal) //將桌位陣列轉為數字字串
     {
    	 String tabletotalStr = "";
    	     for(int i = 0; i < tabletotal.length ; i++)
    	        {
    		   tabletotalStr = tabletotalStr + tabletotal[i];
         	    }
    	 return tabletotalStr;
     }
    //--------------------------------------------------------------------------------//
     
     public String[] sumtabletotal(String tabletotal) //將桌位數字字串轉為陣列
     {
    	 String[] Strtabletotal = new String[tabletotal.length()];
    	 for(int i = 0; i < tabletotal.length() ; i++)
    	        {
    	    	   char chartabletotal = tabletotal.charAt(i);
    	    	   String tabletotalStr = chartabletotal + "";
    	    	   Strtabletotal[i] = tabletotalStr;
         	    }
    	 return Strtabletotal;
     }
        
   }

	   





	

