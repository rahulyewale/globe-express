package com.express.globe.business.service;

import com.express.globe.business.model.OrderDetail;

public class OrderDetailsManager
{
	public static void updateOrderDetail(int i, String cellContent, OrderDetail orderDetail)
	{
		if (!cellContent.isEmpty())
		{
			if (i == 0)
			{

				orderDetail.setSrNo(Long.valueOf(cellContent));
			}
			else if (i == 1)
			{
				orderDetail.setBookingDate(cellContent);
			}
			else if (i == 2)
			{
				orderDetail.setCompanyName(cellContent);
			}
			else if (i == 3)
			{
				orderDetail.setPincode(cellContent);
			}
			else if (i == 4)
			{
				orderDetail.setState(cellContent);
			}
			else if (i == 5)
			{
				orderDetail.setDocumentNo(cellContent);
			}
			else if (i == 6)
			{
				orderDetail.setService(cellContent);
			}
			else if (i == 7)
			{
				orderDetail.setMode(cellContent);
			}
			else if (i == 8)
			{
				orderDetail.setInvoiceNo(cellContent);
			}
			else if (i == 9)
			{
				orderDetail.setInvoiceValue(cellContent);
			}
			else if (i == 10)
			{
				orderDetail.setPackageCount(Long.valueOf(cellContent));
			}
			else if (i == 11)
			{
				orderDetail.setDimensions(cellContent);
			}
			else if (i == 12)
			{
				orderDetail.setRieterWeight(Double.valueOf(cellContent));
			}
			else if (i == 13)
			{
				orderDetail.setFedexWeight(Double.valueOf(cellContent));
			}
			else if (i == 14)
			{
				orderDetail.setStatus(cellContent);
			}
			else if (i == 15)
			{
				orderDetail.setDelayReason(cellContent);
			}
			else if (i == 16)
			{
				orderDetail.setAddress(cellContent);
			}
		}
	}

}
