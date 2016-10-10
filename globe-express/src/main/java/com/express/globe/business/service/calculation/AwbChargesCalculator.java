package com.express.globe.business.service.calculation;

import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.util.ApplicationConfiguration;

public class AwbChargesCalculator
{
	private static final String AWB_CHARGES = "awb.charges";

	public double calculateAwbCharges(OrderDetail orderDetail)
	{
		return Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration(AWB_CHARGES));
	}

}
