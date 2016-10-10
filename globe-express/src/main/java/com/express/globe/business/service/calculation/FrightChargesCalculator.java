package com.express.globe.business.service.calculation;

import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.util.ApplicationConfiguration;

public class FrightChargesCalculator
{
	public double calculateFrightCharges(OrderDetail orderDetail, double calculatedWeight)
	{
		Double rieterWeight = orderDetail.getRieterWeight();
		
		double weightToConsider = (rieterWeight > calculatedWeight) ? rieterWeight : calculatedWeight;
		
		double zoneBasicCharge = Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration(orderDetail.getZone().toLowerCase()+".zone.charge"));
		
		Double frightCharges = weightToConsider * zoneBasicCharge; 
		
		return frightCharges;
	}

}
