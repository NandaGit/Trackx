package com.trackx.truelocate.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.remote.DesiredCapabilities; 


public class GeneralActions {
	public static int i=1;
	public static Logger log4jlogger = Logger.getLogger("devpinoyLogger");
	public static String fsep = System.getProperty("file.separator");
	public static Xlfile_Reader excel = new Xlfile_Reader(
			System.getProperty("user.dir") + fsep + "src" + fsep + "test"
					+ fsep + "resources" + fsep + "Trackx.truelocate.xlsx");
	public static WebDriver driver;
	public static final Logger SELENIUM_LOGS = Logger.getRootLogger();
	public static final Logger APPLICATION_LOGS = Logger
			.getLogger("devpinoyLogger");

	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	public static Map<String, Object[]> TestNGResults;

	public static String dir = System.getProperty("user.dir");

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver launchBrowser(WebDriver driver, String browserType) {
		log4jlogger
				.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		log4jlogger.debug("Instantiating the driver :" + browserType);

		if (browserType.equalsIgnoreCase(Constants.sBrowserFirefox)) {
			log4jlogger.debug("Browser to launch is firefox..");
			System.setProperty(
					"webdriver.gecko.driver",
					(System.getProperty("user.dir") + fsep + "src" + fsep
							+ "test" + fsep + "resources" + fsep + "geckodriver.exe"));
			
			FirefoxProfile profile = new FirefoxProfile();
			profile.setEnableNativeEvents(true);
			// Set Location to store files after downloading.
			profile.setPreference("browser.download.dir",
					"D:\\Screenshot");
			profile.setPreference("browser.download.folderList", 2);
			// Set Preference to not show file download confirmation dialogue
			// using MIME types Of different file extension types.
			profile.setPreference(
					"browser.helperApps.neverAsk.saveToDisk",
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"// MIME types Of MS Excel File.
					+ "application/pdf;" // MIME types Of PDF File.
					+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" // MIME types Of MS doc File.							
					+ "text/plain;" // MIME types Of text File.
					+ "text/csv"); // MIME types Of CSV File.
			profile.setPreference("browser.download.manager.showWhenStarting",
					false);
			profile.setPreference("pdfjs.disabled", true);
			driver = new FirefoxDriver(); 
			driver.manage().window().maximize();
			log4jlogger.debug("Browser launched is firefox and maximized..");
		}

		else if (browserType.equalsIgnoreCase(Constants.sBrowserIe)) {
			System.setProperty(
					"webdriver.ie.driver",
					(System.getProperty("user.dir") + fsep + "src" + fsep
							+ "test" + fsep + "resources" + fsep + "IEDriverServer.exe"));
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("requireWindowFocus", true);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			log4jlogger.debug("Browser launched is IE and maximized..");
			log4jlogger.debug("launching the " + browserType + " browser");
		}

		else if (browserType.equalsIgnoreCase(Constants.sBrowserChrome)) {
			System.setProperty(
					"webdriver.chrome.driver",
					(System.getProperty("user.dir") + fsep + "src" + fsep
							+ "test" + fsep + "resources" + fsep + "chromedriver.exe"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			log4jlogger.debug("launching the " + browserType + " browser");
		}
		getBrowserVersion(driver);
		return driver;
	}

	private static String getBrowserVersion(WebDriver driver) {
		String browserVersion = ((RemoteWebDriver) driver).getCapabilities()
				.getVersion();
		return browserVersion;
	}

	/**
	 * @return Returns true if element is enabled, else return false.
	 */

	public void implicitWaitWithTime(WebDriver driver) {
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			log4jlogger.debug("Implicit wait for given time : 200");
		} catch (Exception e) {
			log4jlogger.error("Exception encountered while waiting");
			e.printStackTrace();
		}
		System.out.println("Long wait completed");
	}

	// Reading the data from the excel file
	public static Object[][] getData(String sheetName) {
		int rows = excel.getRowCount(sheetName) - 1;
		if (rows <= 0) {
			Object data[][] = new Object[1][0];
			return data;
		}

		rows = excel.getRowCount(sheetName);// Get Row Count
		int cols = excel.getColumnCount(sheetName);// Get Col Count
		Object data[][] = new Object[rows - 1][cols];// -1
		for (int rowNum = 2; rowNum <= rows; rowNum++) {// 2
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum,
						rowNum);

			}
		}
		return data;
	}

	@BeforeSuite
	public void excelCreation() {
		// create a new work book
		workbook = new HSSFWorkbook();
		// create a new work sheet
		sheet = workbook.createSheet("TestNG Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		// add test result excel file column header
		// write the header in the first row
		// TestNGResults.put("1", new Object[] { "Test Step No.", "Action",
		// "Expected Action", "Actual Output" });
		TestNGResults.put("1", new Object[] { "Action Executed",
				"Expected Action", "Actual Output" });
	}

	@AfterSuite
	public void suiteTearDown() {
		// write excel file and file name is SaveTestNGResultToExcel.xls
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}

		try {
			FileOutputStream out = new FileOutputStream(new File(
					"TestNGResult.xlsx"));
			workbook.write(out);
			out.close();
			System.out
					.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return Returns the current working directory path.
	 */
	public static String getWorkingDir() {
		String workingDir = "";
		try {
			workingDir = new File(".").getCanonicalPath();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return workingDir;
	}
	
}
