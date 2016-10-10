package com.express.globe.business.service.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.util.ApplicationConfiguration;

public class WeightCalculator
{
	private static final int SURFACE_MODE = 1;
	private static final int AIR_MODE = 2;

	public double calculateWeight(OrderDetail orderDetail)
	{
		double weight = 0;
		String orderDeliveryMode = orderDetail.getMode().toLowerCase();

		int intOrderDeliveryMode = (null != orderDeliveryMode) ? ("air".equals(orderDeliveryMode) ? AIR_MODE : SURFACE_MODE) : SURFACE_MODE;

		Integer surfaceModeDividend = Integer.valueOf(ApplicationConfiguration.getInstance().getConfiguration("surface.mode.dividend"));
		Integer airModeDividend = Integer.valueOf(ApplicationConfiguration.getInstance().getConfiguration("air.mode.dividend"));

		switch(intOrderDeliveryMode)
		{
			case SURFACE_MODE:
				weight = calculateWeightForSurfaceMode(orderDetail, surfaceModeDividend);
				break;
			case AIR_MODE:
				weight = calculateWeightForAirMode(orderDetail, airModeDividend);
				break;
			default:
				weight = calculateWeightForSurfaceMode(orderDetail, surfaceModeDividend);
				break;
		}
		double rieterWeight = orderDetail.getRieterWeight();
		weight = (rieterWeight > weight) ? rieterWeight : weight;

		return weight;
	}

	private double calculateWeightForAirMode(OrderDetail orderDetail, Integer divident)
	{
		double weight = getBasicWeight(orderDetail, divident);

		return weight;
	}

	private double calculateWeightForSurfaceMode(OrderDetail orderDetail, Integer divident)
	{
		double weight = getBasicWeight(orderDetail, divident);
		double remainder = (weight % 5);
		double digitsToAdd = 0.0;
		if (remainder != 0.0)
		{
			digitsToAdd = 5 - remainder;
		}

		weight = weight + digitsToAdd;

		return weight;
	}

	private double getBasicWeight(OrderDetail orderDetail, Integer divident)
	{
		double weight = 0;
		String dimensions = orderDetail.getDimensions();
		String[] allDimensions = dimensions.split(",");
		List<String> allDimensionsList = Arrays.asList(allDimensions);

		for (String dimension : allDimensionsList)
		{
			dimension = dimension.replace("\n", "");
			String[] lbhArray = dimension.split("\\*");

			Integer length = Integer.valueOf(lbhArray[0]);
			Integer breadth = Integer.valueOf(lbhArray[1]);
			Integer height = Integer.valueOf(lbhArray[2]);

			weight = weight + new BigDecimal(length * breadth * height).divide(new BigDecimal(divident), 2, RoundingMode.HALF_UP).doubleValue();
		}

		return weight;
	}

	public static void main(String[] args)
	{
		System.out.println((13 * 10 * 10) / 2250);

		BigDecimal nnd = new BigDecimal(1300).divide(new BigDecimal(2250), 2, RoundingMode.HALF_UP);

		System.out.println(nnd.doubleValue());
	}

}
