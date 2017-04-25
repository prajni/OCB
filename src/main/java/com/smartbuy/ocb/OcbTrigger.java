package com.smartbuy.ocb;

/**
 * OCB Trigger...!
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smartbuy.ocb.bo.OrderCreationBatchBO;
import com.smartbuy.ocb.dto.OrderDTO;
import com.smartbuy.ocb.dto.SkuDTO;
public class OcbTrigger 
{
    public static void main( String[] args )throws Exception
    {
        System.out.println( "We r in OCB Trigger!" );
        
            //Here you should take storenumber as input 
         	
        

    		try {
    			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");

    			OrderCreationBatchBO orderBo = (OrderCreationBatchBO) context.getBean("ocbBO"); // bean id = "ocbBO"
    			List<SkuDTO> skus = orderBo.fetchSkuList("501");
    			if (!skus.equals(null)) {
    				orderBo.executeOrderCreation();
    			}

    			context.close();

    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		// Send an email using Java Mail ApI
    	}
         	
         	
         	
         }
    

