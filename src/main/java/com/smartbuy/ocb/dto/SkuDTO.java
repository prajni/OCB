package com.smartbuy.ocb.dto;

public class SkuDTO {
	
	private String skuNumber;
	private int storeNumber;
	private String skuDescription;
	private int shelfQty;
	private int skuRecommendedThreashold;
	private int inStoreQty;
	private int truckDlvryTime;
	private int skuVelocity;

	
	public SkuDTO(){
		//Default constructor
	}
	
	
	public  SkuDTO(String skuNumber,int storeNumber,int truckDlvryTime,
						int shelfQty,int inStoreQty,int skuRecommendedThreashold,int skuVelocity){
		this.skuNumber = skuNumber;
		this.storeNumber = storeNumber;
		this.truckDlvryTime = truckDlvryTime;
		this.shelfQty = shelfQty;
		this.inStoreQty = inStoreQty;
		this.skuRecommendedThreashold = skuRecommendedThreashold;
		this.skuVelocity = skuVelocity;
		
	}
	
	/**
	 * @return the skuNumber
	 */
	public String getSkuNumber() {
		return skuNumber;
	}
	/**
	 * @param skuNumber the skuNumber to set
	 */
	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}
	
	
	/**
	 * @return the storeNumber
	 */
	public int getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	/**
	 * @return the skuDescription
	 */
	public String getSkuDescription() {
		return skuDescription;
	}
	/**
	 * @param skuDescription the skuDescription to set
	 */
	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}
	/**
	 * @return the skuRecommendedThreashold
	 */
	public int getSkuRecommendedThreashold() {
		return skuRecommendedThreashold;
	}
	public void setSkuRecommendedThreashold(int skuRecommendedThreashold) {
		this.skuRecommendedThreashold = skuRecommendedThreashold;
	}
	/**
	 * @return the InStoreQty
	 */
	
	public int getInStoreQty() {
		return inStoreQty;
	}
	public void setInStoreQty(int inStoreQty) {
		this.inStoreQty = inStoreQty;
	}
	/**
	 * @return the  truckDlvryTime
	 */
	
	public int getTruckDlvryTime() {
		return truckDlvryTime;
	}
	public void setTruckDlvryTime(int truckDlvryTime) {
		this.truckDlvryTime = truckDlvryTime;
	}
	
	/**
	 * @return the  velocity
	 */
	
	public int getSkuVelocity() {
		return skuVelocity;
	}
	public void setSkuVelocity(int skuVelocity) {
		this.skuVelocity = skuVelocity;
	}
	/**
	 * @return the  ShelfQty
	 */
	public int getShelfQty() {
		return shelfQty;
	}
	public void setShelfQty(int shelfQty) {
		this.shelfQty = shelfQty;
	}
	

}
