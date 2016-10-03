package com.express.globe.business.model;


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
private Double awbCharges;
private Double frightCharges;
private Double fovCharges;
private Double odaCharges;
private Double fuelSurcharges;
private Double serviceTax;
private Double totalAmount;

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
public Double getAwbCharges()
{
	return awbCharges;
}
public void setAwbCharges(Double awbCharges)
{
	this.awbCharges = awbCharges;
}
public Double getFrightCharges()
{
	return frightCharges;
}
public void setFrightCharges(Double frightCharges)
{
	this.frightCharges = frightCharges;
}
public Double getFovCharges()
{
	return fovCharges;
}
public void setFovCharges(Double fovCharges)
{
	this.fovCharges = fovCharges;
}
public Double getOdaCharges()
{
	return odaCharges;
}
public void setOdaCharges(Double odaCharges)
{
	this.odaCharges = odaCharges;
}
public Double getFuelSurcharges()
{
	return fuelSurcharges;
}
public void setFuelSurcharges(Double fuelSurcharges)
{
	this.fuelSurcharges = fuelSurcharges;
}
public Double getServiceTax()
{
	return serviceTax;
}
public void setServiceTax(Double serviceTax)
{
	this.serviceTax = serviceTax;
}
public Double getTotalAmount()
{
	return totalAmount;
}
public void setTotalAmount(Double totalAmount)
{
	this.totalAmount = totalAmount;
}

}
