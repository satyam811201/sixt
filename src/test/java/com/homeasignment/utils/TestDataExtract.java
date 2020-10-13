package com.homeasignment.utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDataExtract   {

	/**
	 * Method to obtain the row no of the test name
	 *
	 * @param w
	 *          the workbook to read data from
	 * @param sheetNo
	 *          starting at index 0
	 * @param testName
	 *          - the test name to fetch the data
	 * @return the row no of the test name
	 * @throws IOException
	 */

	public static String testCaseName="";


	public static int obtainRowNo(Workbook w, int sheetNo, String testName) throws IOException {
		int rowNo = -1;
		Sheet sheet = w.getSheet(sheetNo);
		for (int j = 0; j < sheet.getRows(); j++) {
			Cell cell = sheet.getCell(1, j);
			String cellContent = cell.getContents();
			if (cellContent.equals(testName)) {
				rowNo = j;
				break;
			}
		}
		return rowNo;
	}

	public static int obtainColNo(Workbook w, int sheetNo, String colName) throws IOException {
		int colNo = -1;
		Sheet sheet = w.getSheet(sheetNo);
		for (int j = 0; j < sheet.getColumns(); j++) {
			Cell cell = sheet.getCell(j, 0);
			String cellContent = cell.getContents();
			if (cellContent.equals(colName)) {
				colNo = j;
				break;
			}
		}
		return colNo;
	}

	/**
	 * Method obtaining test data of the corresponding test name
	 *
	 * @param fileName
	 *          - name of the excel file
	 * @param sheetNo
	 *          starting at index 0
	 * @param testName
	 *          - the test name to fetch the data
	 * @return hash map containing all the test data
	 * @throws Exception
	 */
	public static HashMap<String, String> obtainTestData(String fileName, int sheetNo, String testName) throws Exception {
		testCaseName=testName; // this for write data function do not remove
		List<Integer> rowList = new ArrayList<Integer>();
		HashMap<String, String> testData = new HashMap<String, String>();
		File inputWorkbook = new File(fileName);
		Workbook w = Workbook.getWorkbook(inputWorkbook);

		// To obtain the row no of the test
		int rowNo = obtainRowNo(w, sheetNo, testName);

		// Add the row nos to the list
		rowList.add(0);
		rowList.add(rowNo);

		// Return if row no is < 0
		if (rowNo < 0) {
			System.out.println("Test Name not found in the excel: " + testName);
		}
		else {
			Sheet sheet = w.getSheet(sheetNo);
			for (int i = 0; i < sheet.getColumns(); i++) {

				String header = sheet.getCell(i, rowList.get(0)).getContents();
				String value = sheet.getCell(i, rowList.get(1)).getContents();
				if (header != "") {
					testData.put(header, value);
				}
				else {
					// WaitUtils.wait(2);
					break;
				}
			}
		}
		return testData;
	}

	public static HashMap<String, String> obtainPassengerTestData(String fileName, int sheetNo, String testName)
			throws Exception {
		List<Integer> rowList = new ArrayList<Integer>();
		HashMap<String, String> testData = new HashMap<String, String>();
		HashMap<String, String> tempData = new HashMap<String, String>();
		File inputWorkbook = new File(fileName);
		Workbook w = Workbook.getWorkbook(inputWorkbook);

		// To obtain the row no of the test
		int rowNo = obtainRowNo(w, sheetNo, testName);
		// Add the row nos to the list
		rowList.add(0);
		rowList.add(rowNo);

		// Return if row no is < 0
		if (rowNo < 0) {
			System.out.println("Test Name not found in the excel: " + testName);
		}
		else {
			Sheet sheet = w.getSheet(sheetNo);
			for (int i = 0; i < sheet.getColumns(); i++) {
				String header = sheet.getCell(i, rowList.get(0)).getContents();
				String value = sheet.getCell(i, rowList.get(1)).getContents();
				if (header.equalsIgnoreCase("NB_ADULTS")) {
					int adultCount = Integer.parseInt(value);
					tempData= obtainData(fileName, 1, adultCount);
					testData.putAll(tempData);
				}
				else if (header.equalsIgnoreCase("NB_CHILDREN")) {
					int childCount = Integer.parseInt(value);
					tempData =obtainData(fileName, 2, childCount);
					testData.putAll(tempData);
				}
				else if (header.equalsIgnoreCase("NB_INFANT")) {
					int infantCount = Integer.parseInt(value);
					tempData =obtainData(fileName, 3, infantCount);
					testData.putAll(tempData);
				}
				else if (header.equalsIgnoreCase("NB_YOUTH")) {
					int youthCount = Integer.parseInt(value);
					tempData =obtainData(fileName, 4, youthCount);
					testData.putAll(tempData);
				}
			}
		}
		return testData;
	}

	public static HashMap<String, String> obtainData(String fileName, int sheetNo, int count) throws Exception {
		HashMap<String, String> testData = new HashMap<String, String>();
		File inputWorkbook = new File(fileName);
		Workbook w = Workbook.getWorkbook(inputWorkbook);
		Sheet sheet = w.getSheet(sheetNo);
		for (int col = 1; col <= count; col++) {
			for (int row = 1; row < sheet.getRows(); row++) {
				String header = sheet.getCell(col, 0).getContents()+sheet.getCell(0, row).getContents();
				String value = sheet.getCell(col, row).getContents();
				if (header != "") {
					testData.put(header, value);
				}
				else {
					
					break;
				}
			}
		}
		return testData;
	}


}
