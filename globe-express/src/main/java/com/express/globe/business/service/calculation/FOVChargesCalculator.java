package com.express.globe.business.service.calculation;

import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.util.ApplicationConfiguration;

public class FOVChargesCalculator
{
	public double calculateFOVCharges(OrderDetail orderDetail)
	{
		double fovChargeApplicableLimit = Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration("fov.charge.applicable.limit"));
		
		double invoiceValue = Double.valueOf(orderDetail.getInvoiceValue());
		double fovChargeAmount = 0;
		
		if (invoiceValue >= fovChargeApplicableLimit)
		{
			double fovChargePercentage = Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration("fov.charge.percentage"));

			fovChargeAmount = Double.valueOf(orderDetail.getInvoiceValue()) * fovChargePercentage;

		}

		return fovChargeAmount;
	}

}
