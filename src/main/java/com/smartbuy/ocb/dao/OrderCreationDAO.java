package com.smartbuy.ocb.dao;

import java.util.List;

import com.smartbuy.ocb.dto.SkuDTO;

public class OrderCreationDAO {

private String getSkusfromStore = "Select sku_num, skuDesc from SKU_STR where SRT_NUM = ?";
	
	
	public List<SkuDTO> getSkusFromStore(String storeNumber) throws Exception{
		
		// Conenction
		// PreparedStatement
		// DB Logic
		
		return null;
	}
}
