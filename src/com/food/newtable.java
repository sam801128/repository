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
	


	//�[���Ϥ�
	static ImageIcon buttoning = new ImageIcon("buttomdd.png");
	static ImageIcon table = new ImageIcon("table.jpg");
	static ImageIcon floor = new ImageIcon("floor.png");
	static JFrame frame;
	static JFrame frames;
	static JButton c1[] = new JButton[2];       //�]�w���Ϋ��s
	static JButton b1[] ;   //�\�U�����\�]���s
	static String[] tabletotal; //�ǤJ��Ʈw��
	
	
	public newtable(){
		
	}

	
	public  newtable(int a){

	JButton b1[] =  new JButton[a]; //�\�U�����\�]���s
	String tabletotal[] = new String[a]; //�ǤJ��Ʈw��
	for(int i = 0 ; i < tabletotal.length ; i++) //�Ntalbletotal�}�C���ȱ��]�w��0
	   {
		tabletotal[i] = "0";
	   }
   //�s�W�\�U�����y�쪺�ج[
    frame = new JFrame("�\�U�����y�쪬�p");
    frame.setBounds(350, 200, 900, 720);
    frame.setResizable(false);
    frame.setAlwaysOnTop(true);//�ܳ�
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setUndecorated(true);
    
    
   //�s�W�y��]�w���ج[
    frames = new JFrame("�]�w���");
    frames.setBounds(1250, 200, 306, 179);
    frames.setResizable(false);//���i���Τ�վ�����j�p
    frames.setAlwaysOnTop(true);//�ܳ�
    frames.setLayout(null);
    frames.setUndecorated(true);



   
 
    //�s�W�y��]�w�����s  �P ���s�ƥ�
    c1[0] = new JButton("�T�w�e�X");
    c1[1] = new JButton("���}");
    c1[0].setBounds(0, 0, 150, 150);
    c1[1].setBounds(150, 0, 150, 150);
    c1[0].addActionListener(new ActionListener() //�e�X���s���ƥ�
       {
         public void actionPerformed(ActionEvent e) 
           {
        	   frame.setAlwaysOnTop(false);
        	   frames.setAlwaysOnTop(false);
         	   int n = JOptionPane.showConfirmDialog(null, "�T�w�N�ثe�\�]�x�s", "�]�w�T�{",JOptionPane.YES_NO_OPTION); //��^�Ȭ�0��1
	               if(n==0)
	               {
  	                   System.out.println("�T�{�]�w�x�s");
  	                   String sumtabletotalStr = sumtabletotal(tabletotal);  //�N���}�C�ন�r��å�String����
  	                   inputable(sumtabletotalStr);//�N�ȶǤJ��Ʈw
	               }
	               else if(n==1)
	               {
	                   System.out.println("�w����");
	               }
           }
       });
    c1[1].addActionListener(new ActionListener() //���}���s���ƥ�
      {
         public void actionPerformed(ActionEvent e) 
           {
    	       System.exit(0);
           }
      });
    frames.add(c1[0]);
    frames.add(c1[1]);
    frames.setVisible(true);

    
 
    
    
    // c1[0].setMnemonic(KeyEvent.VK_D); �j�w���sALT+D
   
    
  //�s�W�y���\�]���s�A�̮ج[�C16�Ӵ���
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
    	    b1[i].addActionListener(new ActionListener() //�]�w���y�쪺���s�ƥ�
    	    {
    	     public void actionPerformed(ActionEvent e) {
    	        
    	        	String c2 = e.getActionCommand();
    	        	int a2 = Integer.parseInt(c2);
    	        	b1[a2].setIcon(buttoning);
    	        	frame.setAlwaysOnTop(false);
    	        	 	        	
    	        	Object[] options ={"���", "���D"};
    	        	int setoption = JOptionPane.showOptionDialog(null, "�N���Ů�]�w��", "�]�w",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, buttoning , options, options[0]); 
                    
    	        	if(setoption == 0){
    	                //int n = JOptionPane.showConfirmDialog(null, "�T�w�]�w���\��", "�]�w�T�{",JOptionPane.YES_NO_OPTION); //��^�Ȭ�0��1
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
    

    
    //�K�[�e���A�Ψӳ]�w�I���Ϥ�
     frame.add(panel);
     frame.setVisible(true);


	    }
	
     public String sumtabletotal(String[] tabletotal) //�N���}�C�ର�Ʀr�r��
     {
    	 String tabletotalStr = "";
    	     for(int i = 0; i < tabletotal.length ; i++)
    	        {
    		   tabletotalStr = tabletotalStr + tabletotal[i];
         	    }
    	 return tabletotalStr;
     }
    //--------------------------------------------------------------------------------//
     
     public String[] sumtabletotal(String tabletotal) //�N���Ʀr�r���ର�}�C
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

	   





	

