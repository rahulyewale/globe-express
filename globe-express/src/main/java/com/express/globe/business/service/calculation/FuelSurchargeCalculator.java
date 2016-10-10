package com.express.globe.business.service.calculation;

import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.util.ApplicationConfiguration;

public class FuelSurchargeCalculator
{
	public double calculateFuelSurcharge(OrderDetail orderDetail, double frightChargesValue)
	{
		double fuelChargePercentage = Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration("fuel.surcharge.percentage"));
		
		double fuelSurchargeAmount = frightChargesValue*(fuelChargePercentage/100);
		
		return fuelSurchargeAmount;
	}

}
