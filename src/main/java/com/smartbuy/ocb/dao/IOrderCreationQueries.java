package com.smartbuy.ocb.dao;

import java.util.List;

import com.smartbuy.ocb.dto.SkuDTO;
import com.smartbuy.ocb.dto.OrderDTO;

public interface IOrderCreationQueries {
	// Any variable in interface is final, static - no duplication
	// Write all queries in here
	//String getSkuFromStore = "select SKU_NUMBER from sku_store where STORE_NUM = ? ";
	
	String getSkusFromStore = "select a.SKU_NUMBER,a.STORE_NUM,a.SKU_VEVOCITY,a.TRK_DLVR_TIME_DAYS, a.SHELF_QTY, a.IN_STR_QTY,  b.SKU_RCMD_THRD  FROM sku_store a ,  sar_parm b  "
			+ "where  a.SKU_NUMBER = b.SKU_NUMBER and a.STORE_NUM = ? ";
	
	// TO GET PO NUMBER
	
	String getPONumber = "select LAST_PO_NUM from po_number";
			
	String updatePONumber = 
			 "UPDATE po_number SET LAST_PO_NUM = ? WHERE LAST_PO_NUM = ?";
	
	String insertValues = " insert  into sar_po (PO_NUMBER,SKU_NUMBER,STR_NUMBER,ORDR_QTY,IS_APPROVED) values (? , ?, ? , ? , ?)" ;

	
	
	public List<SkuDTO> getSkusFromStore(String storeNumber) throws Exception;

	public int getPurchaseOrderNum() throws Exception;
 
	public boolean updateOrderCreation(SkuDTO list,int orderQty,int poNum) throws Exception;

}
