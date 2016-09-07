package com.express.globe.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.BasicConfigurator;

import com.express.globe.business.model.OrderDetail;
import com.express.globe.business.service.InvoiceGenerator;
import com.express.globe.business.service.OrderDetailsManager;

public class ExcelToJtable extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTable table;
	static JScrollPane scroll;
	// header is Vector contains table Column
	@SuppressWarnings("rawtypes")
	static Vector headers = new Vector();
	// Model is used to construct JTable
	static DefaultTableModel model = null;
	// data is Vector contains Data from Excel File
	@SuppressWarnings("rawtypes")
	static Vector data = new Vector();
	static JButton jbClick;
	static int tableWidth = 0; // set the tableWidth
	static int tableHeight = 0; // set the tableHeight
	List<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>();
	String orderDetailsFileName;

	public ExcelToJtable()
	{
		super("Globe Express");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);

		JButton importWeightSheetButton = new JButton("Import Weight Sheet(Excel 97-2003 Workbook Format Only)");
		JButton generateInvoiceButton = new JButton("Generate Invoice");

		buttonPanel.add(importWeightSheetButton, BorderLayout.EAST);
		buttonPanel.add(generateInvoiceButton, BorderLayout.WEST);

		// Show Button Click Event
		importWeightSheetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser jChooser = new JFileChooser();
				jChooser.showOpenDialog(null);

				File file = jChooser.getSelectedFile();
				if (!file.getName().endsWith("xls"))
				{
					JOptionPane.showMessageDialog(null, "Please select Excel 97-2003 Workbook Format Only.", "Wrong Excel Format", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					fillData(file);
					model = new DefaultTableModel(data, headers);
					tableWidth = model.getColumnCount() * 150;
					tableHeight = model.getRowCount() * 25;
					table.setPreferredSize(new Dimension(tableWidth, tableHeight));

					table.setModel(model);
				}
			}
		});

		generateInvoiceButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String invoiceFilePath = null;
				try
				{
					invoiceFilePath = new InvoiceGenerator().generateInvoice(orderDetailsList, orderDetailsFileName);
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}

				if (Desktop.isDesktopSupported())
				{
					try
					{
						File myFile = new File(invoiceFilePath);
						Desktop.getDesktop().open(myFile);
					}
					catch (IOException ex)
					{
						JOptionPane.showMessageDialog(null, "Error Generating Invoice PDF", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		model = new DefaultTableModel(data, headers);

		table.setModel(model);
		table.setBackground(Color.white);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		table.setRowHeight(25);
		table.setRowMargin(4);

		tableWidth = model.getColumnCount() * 150;
		tableHeight = model.getRowCount() * 25;
		table.setPreferredSize(new Dimension(tableWidth, tableHeight));

		scroll = new JScrollPane(table);
		scroll.setBackground(Color.white);
		scroll.setPreferredSize(new Dimension(300, 300));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		setSize(600, 600);
		setResizable(true);
		setVisible(true);
	}

	/**
	 * Fill JTable with Excel file data.
	 * @param file file :contains xls file to display in jTable
	 */
	@SuppressWarnings("unchecked")
	List<OrderDetail> fillData(File file)
	{
		Workbook workbook = null;
		orderDetailsFileName = file.getName();
		try
		{
			try
			{
				workbook = Workbook.getWorkbook(file);
			}
			catch (IOException ex)
			{
				Logger.getLogger(ExcelToJtable.class.getName()).log(Level.SEVERE, null, ex);
			}

			JFrame frame = new JFrame("Input Dialog");

			String selectedSheet = (String) JOptionPane.showInputDialog(frame, "Which worksheet you want to import ?", "Select Worksheet", JOptionPane.QUESTION_MESSAGE, null, workbook.getSheetNames(), null);

			Sheet sheet = null;
			if (null != selectedSheet && !selectedSheet.isEmpty())
			{
				sheet = workbook.getSheet(selectedSheet);
			}
			orderDetailsFileName = "Invoice-"+orderDetailsFileName.replace(".xls", "-")+selectedSheet;
			
			headers.clear();
			for (int i = 0; i < sheet.getColumns(); i++)
			{
				Cell cell1 = sheet.getCell(i, 0);
				headers.add(cell1.getContents());
			}

			data.clear();
			for (int j = 1; j < sheet.getRows(); j++)
			{
				@SuppressWarnings("rawtypes")
				Vector d = new Vector();
				OrderDetail orderDetail = new OrderDetail();

				for (int i = 0; i < sheet.getColumns(); i++)
				{

					Cell cell = sheet.getCell(i, j);

					String cellContent = cell.getContents();

					OrderDetailsManager.updateOrderDetail(i, cellContent, orderDetail);

					d.add(cell.getContents());

				}
				orderDetailsList.add(orderDetail);
				d.add("\n");
				data.add(d);
			}
		}
		catch (BiffException e)
		{
			e.printStackTrace();
		}

		return orderDetailsList;
	}

	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		new ExcelToJtable();
	}
}
