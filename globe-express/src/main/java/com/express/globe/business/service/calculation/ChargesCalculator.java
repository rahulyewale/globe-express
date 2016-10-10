package com.express.globe.business.service.calculation;

import com.express.globe.business.model.InvoiceDetails;
import com.express.globe.business.model.OrderDetail;

public class ChargesCalculator
{
	public final InvoiceDetails getInvoiceDetailsWithCharges(OrderDetail orderDetail)
	{
		double awbCharges = new AwbChargesCalculator().calculateAwbCharges(orderDetail);
		double weightValue = new WeightCalculator().calculateWeight(orderDetail);
		double frightChargesValue = new FrightChargesCalculator().calculateFrightCharges(orderDetail,weightValue);
		double fovChargesValue = new FOVChargesCalculator().calculateFOVCharges(orderDetail);
		double odaCharges = new ODAChargesCalculator().calculateODACharges(orderDetail,weightValue);
		double fuelSurcharge = new FuelSurchargeCalculator().calculateFuelSurcharge(orderDetail,frightChargesValue);

		double totalChargesWithoutServiceTax = awbCharges + frightChargesValue + fovChargesValue + odaCharges + fuelSurcharge;

		double serviceTax = new ServiceTaxCalculator().calculateServiceTax(totalChargesWithoutServiceTax);

		double totalAmount = totalChargesWithoutServiceTax + serviceTax;

		InvoiceDetails invoiceDetails = new InvoiceDetails();
		invoiceDetails.setAwbCharges(awbCharges);
		invoiceDetails.setWeight(String.valueOf(weightValue));
		invoiceDetails.setFrightCharges(frightChargesValue);
		invoiceDetails.setFovCharges(fovChargesValue);
		invoiceDetails.setOdaCharges(odaCharges);
		invoiceDetails.setFuelSurcharges(fuelSurcharge);
		invoiceDetails.setServiceTax(serviceTax);
		invoiceDetails.setTotalAmount(totalAmount);

		return invoiceDetails;
	}

}
