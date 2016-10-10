package com.express.globe.business.service.calculation;

import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.util.ApplicationConfiguration;

public class ODAChargesCalculator
{
	public double calculateODACharges(OrderDetail orderDetail, double weightValue)
	{
		double finalOdaCharges = 0;
		if (orderDetail.getService().equalsIgnoreCase("oda"))
		{
			double constantODACharge = Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration("constant.oda.charges"));

			double odaChargePerKg = Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration("oda.chrage.per.kg"));

			double calculatedODACharge = weightValue * odaChargePerKg;

			finalOdaCharges = (calculatedODACharge > constantODACharge) ? calculatedODACharge : constantODACharge;
		}

		return finalOdaCharges;
	}

}
