package com.express.globe.business.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import org.apache.log4j.Logger;

import com.express.globe.business.model.InvoiceDetails;
import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.calculation.ChargesCalculator;

public class InvoiceGenerator
{
	static final Logger logger = Logger.getLogger(InvoiceGenerator.class);

	public String generateInvoice(List<OrderDetail> orderDetailsList, String orderDetailsFileName) throws Exception
	{
		logger.debug("Hello World!");

		List<InvoiceDetails> invoiceDetailsList = new ArrayList<InvoiceDetails>();

		for (OrderDetail orderDetail : orderDetailsList)
		{
			com.express.globe.business.model.InvoiceDetails invoiceDetails = createInvoice(orderDetail);

			if (null != invoiceDetails)
				invoiceDetailsList.add(invoiceDetails);
		}

		/*
		 * ClassLoader classLoader = getClass().getClassLoader(); File file = new
		 * File(classLoader.getResource("file/test.xml").getFile());
		 */
		//String pathForSaving = "E:\\Reports\\" + orderDetailsFileName + ".pdf";
		String pathForSaving = ".\\" + orderDetailsFileName + ".pdf";
	//	String pathForMaster = "E:\\Rahul\\sunilj\\report\\jrxml\\master.jrxml";
	//	String subReportFileName = "E:\\Rahul\\sunilj\\report\\jrxml\\sub.jrxml";

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(invoiceDetailsList);
		Map<String, Object> parameters = new HashMap<String, Object>();

		try
		{
			//File masterReportPattern = new File(ClassLoader.getSystemClassLoader().getResource("master.jrxml").getFile());
			
			JasperDesign jasperDesign = JRXmlLoader.load(getClass().getResourceAsStream("/master.jrxml"));
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			// subRepPattern = new File(ClassLoader.getSystemClassLoader().getResource("sub.jrxml").getFile());
			JasperDesign subRepPatternDesign = JRXmlLoader.load(getClass().getResourceAsStream("/sub.jrxml"));
			JasperReport jasperSubReport = JasperCompileManager.compileReport(subRepPatternDesign);

			parameters.put("subreportParameter", jasperSubReport);

			String orderDetailsName = "Globe-Express" + orderDetailsFileName;
			parameters.put("orderDetailName", orderDetailsName);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSaving);

		}
		catch (Exception e)
		{
			logger.error("error", e);
		}
		return pathForSaving;

	}

	private InvoiceDetails createInvoice(OrderDetail orderDetail)
	{
		InvoiceDetails invoiceDetails = null;
		if (null != orderDetail.getSrNo() && !orderDetail.getSrNo().equals(0))
		{
			invoiceDetails = new ChargesCalculator().calculateInvoiceDetails(orderDetail);

			invoiceDetails.setAwbNo(orderDetail.getDocumentNo());

			invoiceDetails.setDeliveryDate(orderDetail.getBookingDate());
			invoiceDetails.setPieces(String.valueOf(orderDetail.getPackageCount()));
			invoiceDetails.setRecepient(orderDetail.getAddress());
			invoiceDetails.setRefNo(orderDetail.getInvoiceNo());

			String shipper = "Rieter India Pvt. Ltd.Shindewadi,Shirwal.";

			invoiceDetails.setShipper(shipper);
			invoiceDetails.setShippingDate(orderDetail.getBookingDate());
		}
		return invoiceDetails;

	}

	public void createMaster() throws JRException
	{
		String pathForSaving = "E:\\Rahul\\sunilj\\report\\master.pdf";
		String pathForSavingxl = "E:\\Rahul\\sunilj\\report\\master.xlsx";
		//String pathForSavingdocx = "E:\\Rahul\\sunilj\\report\\master.docx";
		String pathForMaster = "E:\\Rahul\\sunilj\\report\\jrxml\\master.jrxml";
		String subReportFileName = "E:\\Rahul\\sunilj\\report\\jrxml\\sub.jrxml";

		InvoiceDetails invoiceDetails = new InvoiceDetails();

		invoiceDetails.setAwbNo("8097780229");
		invoiceDetails.setDeliveryDate("22-Apr-2016");
		invoiceDetails.setPieces("1");
		invoiceDetails.setRecepient("Rahul Yewlale, \n Dynamic Enclave");
		invoiceDetails.setRefNo("7045234320");
		invoiceDetails.setShipper("Sunil Jare, Shirwal");
		invoiceDetails.setShippingDate("10-May-2016");
		invoiceDetails.setWeight("10");

		/*invoiceDetails.setAwbCharges(123);
		invoiceDetails.setFovCharges(345);
		invoiceDetails.setFrightCharges(12345);
		invoiceDetails.setFuelSurcharges(5555);
		invoiceDetails.setOdaCharges(345);
		invoiceDetails.setServiceTax(543);
		invoiceDetails.setTotalAmount(112345);*/


		InvoiceDetails invoiceDetails1 = new InvoiceDetails();

		invoiceDetails1.setAwbNo("7678865445");
		invoiceDetails1.setDeliveryDate("24-Apr-2016");
		invoiceDetails1.setPieces("2");
		invoiceDetails1.setRecepient("Yuvraj Yewlale, Sai Pooja - Dynamic Enclave");
		invoiceDetails1.setRefNo("7045234320");
		invoiceDetails1.setShipper("Sunil Jare, Shirwal");
		invoiceDetails1.setShippingDate("16-May-2016");
		invoiceDetails1.setWeight("108");

		/*invoiceDetails1.setAwbCharges(435);
		invoiceDetails1.setFovCharges(645);
		invoiceDetails1.setFrightCharges(54);
		invoiceDetails1.setFuelSurcharges(455);
		invoiceDetails1.setOdaCharges(346);
		invoiceDetails1.setServiceTax(765);
		invoiceDetails1.setTotalAmount(2344);*/


		ArrayList<InvoiceDetails> dataBeanList = new ArrayList<InvoiceDetails>();

		dataBeanList.add(invoiceDetails);
		dataBeanList.add(invoiceDetails1);

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		Map<String, Object> parameters = new HashMap<String, Object>();

		File masterReportPattern = new File(pathForMaster);
		JasperDesign jasperDesign = JRXmlLoader.load(masterReportPattern);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

		File subRepPattern = new File(subReportFileName);
		JasperDesign subRepPatternDesign = JRXmlLoader.load(subRepPattern);
		JasperReport jasperSubReport = JasperCompileManager.compileReport(subRepPatternDesign);

		parameters.put("subreportParameter", jasperSubReport);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSaving);

		// Export to excel
		JRXlsxExporter exporter = new JRXlsxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		File outputFile = new File(pathForSavingxl);
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile));
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setDetectCellType(true);// Set configuration as you like
															// it!!
		configuration.setCollapseRowSpan(false);
		exporter.setConfiguration(configuration);
		exporter.exportReport();

	}

}