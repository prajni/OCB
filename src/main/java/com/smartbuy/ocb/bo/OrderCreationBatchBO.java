package com.smartbuy.ocb.bo;
import com.smartbuy.ocb.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

import com.smartbuy.ocb.dao.IOrderCreationQueries;
import com.smartbuy.ocb.dao.OrderCreationDAO;
import com.smartbuy.ocb.dto.OrderDTO;
import com.smartbuy.ocb.dto.SkuDTO;

public class OrderCreationBatchBO {
	
	private IOrderCreationQueries dao = null;
	List<SkuDTO> skuList = new ArrayList<SkuDTO>();
	OrderDTO dto = new OrderDTO();

	public OrderCreationBatchBO() {

	}

	public void setDao(IOrderCreationQueries dao) {
		this.dao = dao;
	}

	public List<SkuDTO> fetchSkuList(String storeNum) throws Exception {

		skuList = dao.getSkusFromStore(storeNum);

		return skuList;
	}

	
	public void executeOrderCreation() throws Exception {
		OrderDTO dto = new OrderDTO();
		for (SkuDTO sList : skuList) {
			System.out.println("List of Skudetails :" + sList.getSkuNumber() + " " + sList.getShelfQty() + " "
					+ sList.getInStoreQty() + " " + sList.getSkuRecommendedThreashold());

			int qty = sList.getShelfQty() + sList.getInStoreQty();
			System.out.println("Total Quantity :" + qty);

			if (qty < sList.getSkuRecommendedThreashold()) {
				// //order quantity calc
				int skuVel = (sList.getSkuVelocity());
				int orderQty = skuVel * sList.getTruckDlvryTime();
				dto.setSkuDto(sList);
				dto.setOrderQty(orderQty);
				
				//get Purchase order number
				int poNum = dao.getPurchaseOrderNum();
//				System.out.println(poNum);
				
				// if PO is not empty populate Sar_Po table with the new PO Number and Sku number
				if (poNum != 0) {
				boolean value =	dao.updateOrderCreation(sList,orderQty,poNum);
					if(!value){
						break;
					}
				}
			}
			
		}

	}


}
