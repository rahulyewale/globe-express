package com.express.globe.business.model;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDetails
{
private String awbNo;
private String refNo;
private String shippingDate;
private String deliveryDate;
private String shipper;
private String recepient;
private String pieces;
private String weight;
private Integer awbCharges;
private Integer frightCharges;
private Integer fovCharges;
private Integer odaCharges;
private Integer fuelSurcharges;
private Integer serviceTax;
private Integer totalAmount;
private List<ChargeDetails> serviceChargeList = new ArrayList<ChargeDetails>();

public String getAwbNo()
{
	return awbNo;
}
public void setAwbNo(String awbNo)
{
	this.awbNo = awbNo;
}
public String getRefNo()
{
	return refNo;
}
public void setRefNo(String refNo)
{
	this.refNo = refNo;
}
public String getShippingDate()
{
	return shippingDate;
}
public void setShippingDate(String shippingDate)
{
	this.shippingDate = shippingDate;
}
public String getDeliveryDate()
{
	return deliveryDate;
}
public void setDeliveryDate(String deliveryDate)
{
	this.deliveryDate = deliveryDate;
}
public String getShipper()
{
	return shipper;
}
public void setShipper(String shipper)
{
	this.shipper = shipper;
}
public String getRecepient()
{
	return recepient;
}
public void setRecepient(String recepient)
{
	this.recepient = recepient;
}
public String getPieces()
{
	return pieces;
}
public void setPieces(String pieces)
{
	this.pieces = pieces;
}
public String getWeight()
{
	return weight;
}
public void setWeight(String weight)
{
	this.weight = weight;
}
public List<ChargeDetails> getServiceChargeList()
{
	return serviceChargeList;
}
public void setServiceChargeList(List<ChargeDetails> serviceChargeList)
{
	this.serviceChargeList = serviceChargeList;
}
public Integer getAwbCharges()
{
	return awbCharges;
}
public void setAwbCharges(Integer awbCharges)
{
	this.awbCharges = awbCharges;
}
public Integer getFrightCharges()
{
	return frightCharges;
}
public void setFrightCharges(Integer frightCharges)
{
	this.frightCharges = frightCharges;
}
public Integer getFovCharges()
{
	return fovCharges;
}
public void setFovCharges(Integer fovCharges)
{
	this.fovCharges = fovCharges;
}
public Integer getOdaCharges()
{
	return odaCharges;
}
public void setOdaCharges(Integer odaCharges)
{
	this.odaCharges = odaCharges;
}
public Integer getFuelSurcharges()
{
	return fuelSurcharges;
}
public void setFuelSurcharges(Integer fuelSurcharges)
{
	this.fuelSurcharges = fuelSurcharges;
}
public Integer getServiceTax()
{
	return serviceTax;
}
public void setServiceTax(Integer serviceTax)
{
	this.serviceTax = serviceTax;
}
public Integer getTotalAmount()
{
	return totalAmount;
}
public void setTotalAmount(Integer totalAmount)
{
	this.totalAmount = totalAmount;
}

}
