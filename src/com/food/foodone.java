package com.food;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class foodone {
	    
	    static Connection connect = null;
	    static Statement stmt = null;
	    
	public static void main (String[] args) {
	    
		try {  
	        Class.forName("com.mysql.cj.jdbc.Driver");     //��蝸MYSQL JDBC撽勗蝔��     
	        //Class.forName("org.gjt.mm.mysql.Driver");  
	       System.out.println("Success loading Mysql Driver!");  
	      }  
	      catch (Exception e) {  
	        System.out.print("Error loading Mysql Driver!");  
	        e.printStackTrace();  
	      }  
	      try {  
	            connect = DriverManager.getConnection(  
	            "jdbc:mysql://localhost:3306/food?serverTimezone=UTC","libar","m2569758");  
	             //餈URL銝�   jdbc:mysql//������/��摨��  嚗����2銝芸�������������� 敹◆�摰��  
	    
	        System.out.println("Success connect MySql server!");
	        stmt = connect.createStatement();  


	        ResultSet rs = stmt.executeQuery("select * from foodtable");
	                                                                
	        while (rs.next()) {
	        	
	          System.out.println(rs.getString("撣唾��"));  
	          System.out.println(rs.getString("撖Ⅳ"));
	          System.out.println(rs.getString("�閮剔�瘜�"));
	        }  
	      }  
	      catch (Exception e) {  
	        System.out.print("get data error!");  
	        e.printStackTrace();  
	      }  
	      

//-------------------------------------------------------------------------------------------------------		
		//閰Ｗ�蝙���閬��漣雿�
	      
	   
	   
	   JFrame frameq = new JFrame("擗輒閬芋閮剖��");
	   frameq.setBounds(600, 300, 500, 100);
	   frameq.setResizable(false);
	   frameq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	   
	   frameq.setLayout(null);
	   JButton q1=new JButton("蝣箏�漣雿");
	   q1.setBounds(380, 10, 100, 50);

	   
	   
	   JTextField jt = new JTextField();
	   jt.setBounds(10, 10, 100, 50);
	   frameq.add(q1);
	   frameq.add(jt);
	   
	   frameq.setVisible(true);
	   foodtabledemo foodtabledemo = new foodtabledemo();
	  
	  
	   
	   q1.addActionListener(new ActionListener() { //Q1����辣������!
   
           public void actionPerformed(ActionEvent e) {
 
        	  
        	   if(jt.getText().equals("憭�")){
        	   frameq.setVisible(false);//����
        	   newtable newtable = new newtable(176);
        	   }else if(jt.getText().equals("撠�")){
        	    frameq.setVisible(false);//����
        	   newtable newtable = new newtable(10);
        	   }
        		   
           }
       });
 
	}
	   public void inputable(String sumtabletotalStr){
	         try
	             {
	               stmt.executeUpdate("UPDATE foodtable set �閮剔�瘜� = '"+sumtabletotalStr+"' where sn = '1' AND 撣唾�� = 'Zad' AND 撖Ⅳ = 'Ali'");
	               System.out.println("�憓���");
	             }
	         catch (Exception e) 
	             { 
	        	   System.out.println("��鞈�澈憭望��");
	             }
	         
	   }
	         
	   public  String selecttable(){
		         try
		             {
		        	   ResultSet rs = stmt.executeQuery("select �閮剔�瘜�  from foodtable  where sn = '1' AND 撣唾�� = 'Zad' AND 撖Ⅳ = 'Ali'");
		        	   while (rs.next()){
		        	   String selecttable =  rs.getString("�閮剔�瘜�");
		        	   return selecttable;
		        	   }
		             }
		         catch (Exception e) 
		             { 
		        	   System.out.println("��鞈�澈憭望��");
		             }
		         
		         return "";
		          
      }

}
