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
	        Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序     
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
	             //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码 必须自定义  
	    
	        System.out.println("Success connect MySql server!");
	        stmt = connect.createStatement();  


	        ResultSet rs = stmt.executeQuery("select * from foodtable");
	                                                                
	        while (rs.next()) {
	        	
	          System.out.println(rs.getString("帳號"));  
	          System.out.println(rs.getString("密碼"));
	          System.out.println(rs.getString("擺設狀況"));
	        }  
	      }  
	      catch (Exception e) {  
	        System.out.print("get data error!");  
	        e.printStackTrace();  
	      }  
	      

//-------------------------------------------------------------------------------------------------------		
		//詢問使用者需要多少座位
	      
	   
	   
	   JFrame frameq = new JFrame("餐廳規模設定");
	   frameq.setBounds(600, 300, 500, 100);
	   frameq.setResizable(false);
	   frameq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	   
	   frameq.setLayout(null);
	   JButton q1=new JButton("確定座位數");
	   q1.setBounds(380, 10, 100, 50);

	   
	   
	   JTextField jt = new JTextField();
	   jt.setBounds(10, 10, 100, 50);
	   frameq.add(q1);
	   frameq.add(jt);
	   
	   frameq.setVisible(true);
	   foodtabledemo foodtabledemo = new foodtabledemo();
	  
	  
	   
	   q1.addActionListener(new ActionListener() { //Q1按鈕事件啟動時做!
   
           public void actionPerformed(ActionEvent e) {
 
        	  
        	   if(jt.getText().equals("大")){
        	   frameq.setVisible(false);//關閉窗口
        	   newtable newtable = new newtable(176);
        	   }else if(jt.getText().equals("小")){
        	    frameq.setVisible(false);//關閉窗口
        	   newtable newtable = new newtable(10);
        	   }
        		   
           }
       });
 
	}
	   public void inputable(String sumtabletotalStr){
	         try
	             {
	               stmt.executeUpdate("UPDATE foodtable set 擺設狀況 = '"+sumtabletotalStr+"' where sn = '1' AND 帳號 = 'Zad' AND 密碼 = 'Ali'");
	               System.out.println("新增成功");
	             }
	         catch (Exception e) 
	             { 
	        	   System.out.println("傳入資料庫失敗");
	             }
	         
	   }
	         
	   public  String selecttable(){
		         try
		             {
		        	   ResultSet rs = stmt.executeQuery("select 擺設狀況  from foodtable  where sn = '1' AND 帳號 = 'Zad' AND 密碼 = 'Ali'");
		        	   while (rs.next()){
		        	   String selecttable =  rs.getString("擺設狀況");
		        	   return selecttable;
		        	   }
		             }
		         catch (Exception e) 
		             { 
		        	   System.out.println("傳入資料庫失敗");
		             }
		         
		         return "";
		          
      }

}
