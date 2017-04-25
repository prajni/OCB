package com.smartbuy.ocb.dto;

import java.util.List;

public class OrderDTO {
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	//private List<SkuDTO> skuList;
	
    private int orderQty,PONumber;
    private SkuDTO skuDto;
    
    public SkuDTO getSkuDto() {
		return skuDto;
	}
	public void setSkuDto(SkuDTO skuDto) {
		this.skuDto = skuDto;
	}
	
	// returns OrderQty
	
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	// returns PO number 
	
	public int getPONumber() {
		return PONumber;
	}
	public void setPONumber(int pONumber) {
		PONumber = pONumber;
	}
	
}
