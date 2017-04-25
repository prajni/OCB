package com.smartbuy.ocb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.smartbuy.ocb.dto.SkuDTO;

 import com.smartbuy.ocb.dto.OrderDTO;

public class OrderCreationDAO implements IOrderCreationQueries{
	
	 DbUtil util = new DbUtil();	
	
	// TO-DO - all method implemetation of methods ... here
	    
    //List<SkuDTO> skuListNeed = new ArrayList<SkuDTO>();
	
	// 1.METHOD TO GET SKU DETAILS FROM SKUSTORE
	
	public List<SkuDTO> getSkusFromStore(String storeNumber) throws Exception {
List<SkuDTO> skuList = new ArrayList<SkuDTO>();
try{
if(storeNumber != null && storeNumber.trim().length() >0 ){
	Connection conn = util.DbConnection();
	PreparedStatement  pStat = conn.prepareStatement(getSkusFromStore);
	pStat.setString(1, storeNumber);
	SkuDTO skuInfo = new SkuDTO();
	ResultSet rs = pStat.executeQuery();
	String skuNumber = null;
	int i;
	while(rs.next()){
		i=0;
		
		skuInfo.setSkuNumber(rs.getString("SKU_NUMBER"));	
		skuInfo.setStoreNumber(rs.getInt("STORE_NUM"));
		skuInfo.setSkuVelocity(rs.getInt("SKU_VELOCITY"));
		skuInfo.setTruckDlvryTime(rs.getInt("TRK_DLVR_TIME_DAYS"));
		skuInfo.setShelfQty(rs.getInt("SHELF_QTY"));
		skuInfo.setInStoreQty(rs.getInt("IN_STR_QTY"));
		skuInfo.setSkuRecommendedThreashold(rs.getInt("SKU_RCMD_THRD"));
		skuList.add(i, skuInfo);
		i++;
		
	    }//while close
      }//if-close

}catch
(Exception e){
    e.printStackTrace();
	}finally{
			util.closeConnection();
			}

return skuList;
} // CLOSING -METHOD TO GET SKU DETAILS FROM SKUSTORE
	
	// 2.METHOD TO getPurchaseOrderNum
	
	public int getPurchaseOrderNum() throws Exception {
		// TODO Auto-generated method stub
		OrderDTO PONum = new OrderDTO();
		PreparedStatement psSelect = null;
		PreparedStatement psUpdate = null;
		ResultSet rs = null;
		int poNum =0;
		try{
			
			Connection conn = util.DbConnection();
			  psSelect = conn.prepareStatement(getPONumber);
			rs = psSelect.executeQuery();
			while(rs.next()){
				PONum.setPONumber(rs.getInt("LAST_PO_NUM"));
				poNum = PONum.getPONumber();
				poNum = poNum + 1;
			}
			
			if(!PONum.equals(null)){
				psUpdate = conn.prepareStatement(updatePONumber);
				psUpdate.setInt(1,poNum);
				psUpdate.setInt(2, PONum.getPONumber());
				
				psUpdate.executeUpdate();
				System.out.println(poNum);
				conn.commit();
			}
		}catch(Exception e){
            e.printStackTrace();
			}finally{
					util.closeConnection();
					}
		
	return poNum;
	}
	// 2.CLOSING -METHOD TO getPurchaseOrderNum
	
	
	// 3.METHOD TO UPDATE ORDER CREATION
	public boolean updateOrderCreation(SkuDTO list,int orderQty,int poNum) throws Exception {
		// TODO Auto-generated method stub
		SkuDTO skus = new SkuDTO();
		OrderDTO order = new OrderDTO();
		
		try{
			Connection conn = util.DbConnection();
			PreparedStatement psInsert = null;
			psInsert = conn.prepareStatement(insertValues);
			String poValue = Integer.toString(poNum);
			psInsert.setString(1, poValue);
			psInsert.setString(2, list.getSkuNumber());
			psInsert.setInt(3, list.getStoreNumber());
			psInsert.setInt(4, orderQty);
			psInsert.setInt(5, 1);
			
			psInsert.executeUpdate();
			psInsert.close();
			
		}catch(Exception e){
            e.printStackTrace();
			}finally{
					util.closeConnection();
					}
		
		return true;
	}
	
		// 3.CLOSING -METHOD TO UPDATE ORDER CREATION
}	
	
	