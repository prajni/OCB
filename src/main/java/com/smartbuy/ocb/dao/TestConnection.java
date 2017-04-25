package com.smartbuy.ocb.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
public class TestConnection {

	public static void main(String[] args) throws SQLException {
		
		
		Connection daoCon= null;
		  daoCon = DbUtil.DbConnection();
		  System.out.println("connection came from DbUtilClass");
		  Statement mystmt = null;  
		  mystmt = daoCon.createStatement();
		   
			
			try{
	      	 
	      	ResultSet myRs =  mystmt.executeQuery("select SKU_NUMBER from sku_store where STORE_NUM = '501' ");
	      	  while (myRs.next())
	      	  {
	      		  System.out.println(myRs.getString("SKU_NUMBER") );
	      		  
	      		  
	      	  }
	        }
	        catch (Exception exc)
	        {
	      	  exc.printStackTrace();
	        }
					
			try {
				
				DbUtil.closeConnection();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
	}

	}


