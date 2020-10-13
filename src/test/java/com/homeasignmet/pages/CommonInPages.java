package com.homeasignmet.pages;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.homeasignment.utils.SeleniumDriver;
import com.homeasignment.utils.TestDataExtract;

public class CommonInPages {
	public static String relativeURL;

	public static String from;

	public static String to;

	public static String departure_date;

	public static String arrival_date;

	public static String adults;

	public static String children;

	public static String infants;

	public static String youths;

	public static int adtCount;

	public static int chdCount;

	public static int infCount;

	public static int youthCount;

	public static String loginUsername;
	public static String Fname;
	public static String Lname;
	public static String mobileno;
	public static String email;

	protected static String LOC_XLS_CXTestData = "HUTestData.xls";


	public static String strOutputFilePath = System.getProperty("user.dir");
	public static String strOutPutFolderPath = System.getProperty("user.dir");	
	public static List<String> userTypes = new ArrayList<String>();
	protected static String LOC_XLS_CX = System.getProperty("user.dir") + "\\HUTestData.xls";
	public static String testCaseName = "",startDate,endDate,promotype=null; // x?
	public static String browser;
	public static String url;
	public HashMap<String, String> testData = null;
	public HashMap<String, String> additionalTestData = null;
	public static GlobalVariablesMethods variblesMethods;


	public void testConfiguration(String testCase) throws Exception {

		testData = TestDataExtract.obtainTestData(LOC_XLS_CX, 0, testCase);
		additionalTestData = TestDataExtract.obtainPassengerTestData(LOC_XLS_CX, 0, testCase);
		testData.putAll(additionalTestData);		
		addExcelSheetValuesToGlobalMap(testData);
		InitializeInputs();
	}


	public void getTestData(String testCase) throws Exception{
		testData = TestDataExtract.obtainTestData(LOC_XLS_CXTestData, 1, testCase);
		additionalTestData=TestDataExtract.obtainTestData(variblesMethods.LOC_XLS_CXTestData, 2, testCase);
		testData.putAll(additionalTestData);
		additionalTestData=TestDataExtract.obtainTestData(variblesMethods.LOC_XLS_CXTestData, 6, testCase);
		testData.putAll(additionalTestData);
	}

	public void getPaxTestData(String testCase) throws Exception{
		TestDataExtract testData1=new TestDataExtract();
		additionalTestData = testData1.obtainPassengerTestData(variblesMethods.LOC_XLS_CXTestData, 1, testCase);
		testData.putAll(additionalTestData);
	}

	public void addExcelSheetValuesToGlobalMap(HashMap<String, String> exceldata) throws Exception {
		for (String key : exceldata.keySet()) {
			String strValue = exceldata.get(key);
			if (!strValue.isEmpty()) {
				setValue(key.trim(), strValue.trim());
			}
		}
	}
	public void setValue(String key, String value) throws Exception {
		setOutputValue(key.trim(), value.trim());
	}
	public void launchApplicationEntryFlow() throws Exception {

		relativeURL = getValue("URL").trim();

		SeleniumDriver.getDriver().get(relativeURL);
		SeleniumDriver.getDriver().manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		maximizeBrowser();

	}
	public void maximizeBrowser() {
		SeleniumDriver.getDriver().manage().window().maximize();
	}

	public void InitializeInputs() throws IOException, ParseException{

		from     = getValue("DEPARTURE_CITY").trim();
		to 	     = getValue("ARRIVAL_CITY").trim();
		adults 	 = getValue("NB_ADULTS").trim();
		children = getValue("NB_CHILDREN").trim();
		infants  = getValue("NB_INFANT").trim();
		youths	 = getValue("NB_YOUTH").trim();
		adtCount = Integer.parseInt(adults);
		chdCount = Integer.parseInt(children);
		infCount  = Integer.parseInt(infants);
		youthCount = Integer.parseInt(youths);
		loginUsername=getValue("LOGIN_USERNAME").trim();
		Fname=getValue("FIRST_NAME").trim();
		Lname=getValue("LAST_NAME").trim();
		mobileno=getValue("PHONE_NUMBER").trim();
		email=getValue("EMAIL_ADDRESS").trim();
	}
	public String getValue(String key) {
		String value;
		value = getOutputValue(key.trim());
		if (value == null) {
			value = "0";
		}
		System.out.println("Value for "+key+":"+" "+value);
		return value.trim();
	}	

	public String getOutputValue(String key) {
		String value = null;
		try {
			value = SeleniumDriver.dataMap.get(key.toUpperCase());
		} catch (Exception e) {
			value = "";
			SeleniumDriver.reporter.report("Output parameter", "The value of key '" + key +"' is not recognized as an integer.");			 
		}
		return value;
	}

	public String setOutputValue(String key, String data) throws Exception {
		return SeleniumDriver.dataMap.put(key.toUpperCase(), data);
	}


}