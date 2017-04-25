package com.smartbuy.ocb.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	
	   public Connection mycon= null;
	  public  Statement mystmt = null;   
	   
	   // To Create Connection
	   
	  public Connection DbConnection()
	    {
		 
		 
		 try{ 
       	   mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/scm?useSSL=false","root","prajni8989");
       	  
       	  System.out.println("connection created");
       	   
            }
         catch (Exception exc)
         {
       	  exc.printStackTrace();
         }
	
		 return mycon;
	 }
	 
	  // To Close connection
	  
	 public void  closeConnection() throws SQLException {
	      mycon.close();
		
		 
	 }
	 
	 
		
		   
		}	


