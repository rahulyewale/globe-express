package com.express.globe.business.service.calculation;

import com.express.globe.business.service.util.ApplicationConfiguration;


public class ServiceTaxCalculator
{
	public double calculateServiceTax(double totalChargesWithoutServiceTax)
	{
		double serviceTaxPercentage = Double.valueOf(ApplicationConfiguration.getInstance().getConfiguration("service.tax.percentage"));
		
		double totalChargesIncludingServiceTax = totalChargesWithoutServiceTax*(serviceTaxPercentage/100);
		
		return totalChargesIncludingServiceTax;
	}

}
