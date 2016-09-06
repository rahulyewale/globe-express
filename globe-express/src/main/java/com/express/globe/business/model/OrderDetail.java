package com.express.globe.business.model;

import java.io.Serializable;

/**
 * The persistent class for the order_details database table.
 */
public class OrderDetail implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer orderDetailsId;

	private String address;

	private String bookingDate;

	private String companyName;

	private String delayReason;

	private String dimensions;

	private String documentNo;

	private Double fedexWeight;

	private String invoiceNo;

	private String invoiceValue;

	private String mode;

	private Long packageCount;

	private String pincode;

	private Double rieterWeight;

	private String service;

	private Long srNo;

	private String state;

	private String status;

	public OrderDetail()
	{
	}

	public Integer getOrderDetailsId()
	{
		return this.orderDetailsId;
	}

	public void setOrderDetailsId(Integer orderDetailsId)
	{
		this.orderDetailsId = orderDetailsId;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getBookingDate()
	{
		return this.bookingDate;
	}

	public void setBookingDate(String bookingDate)
	{
		this.bookingDate = bookingDate;
	}

	public String getCompanyName()
	{
		return this.companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getDelayReason()
	{
		return this.delayReason;
	}

	public void setDelayReason(String delayReason)
	{
		this.delayReason = delayReason;
	}

	public String getDimensions()
	{
		return this.dimensions;
	}

	public void setDimensions(String dimensions)
	{
		this.dimensions = dimensions;
	}

	public String getDocumentNo()
	{
		return this.documentNo;
	}

	public void setDocumentNo(String documentNo)
	{
		this.documentNo = documentNo;
	}

	public String getInvoiceNo()
	{
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo)
	{
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceValue()
	{
		return this.invoiceValue;
	}

	public void setInvoiceValue(String invoiceValue)
	{
		this.invoiceValue = invoiceValue;
	}

	public String getMode()
	{
		return this.mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public Long getPackageCount()
	{
		return this.packageCount;
	}

	public void setPackageCount(Long packageCount)
	{
		this.packageCount = packageCount;
	}

	public String getPincode()
	{
		return this.pincode;
	}

	public void setPincode(String pincode)
	{
		this.pincode = pincode;
	}

	public String getService()
	{
		return this.service;
	}

	public void setService(String service)
	{
		this.service = service;
	}

	public Long getSrNo()
	{
		return this.srNo;
	}

	public void setSrNo(Long srNo)
	{
		this.srNo = srNo;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Double getFedexWeight()
	{
		return fedexWeight;
	}

	public void setFedexWeight(Double fedexWeight)
	{
		this.fedexWeight = fedexWeight;
	}

	public Double getRieterWeight()
	{
		return rieterWeight;
	}

	public void setRieterWeight(Double rieterWeight)
	{
		this.rieterWeight = rieterWeight;
	}

}