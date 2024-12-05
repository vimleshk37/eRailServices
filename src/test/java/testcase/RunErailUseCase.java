package testcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import methods.CommonMethod;
import utilities.ReadXLSDdata;
import utilities.WriteXLSDdata;

public class RunErailUseCase extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public static void fromStationSelection() throws IOException, InterruptedException {
		CommonMethod method = new CommonMethod();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement fromDate = driver.findElement(By.xpath(locaters.getProperty("FromStation")));
		fromDate.click(); // Step 2: Click on from field.
		fromDate.clear(); // Step 3: Clear the data from â€œFromâ€� field.
		fromDate.sendKeys(prop.getProperty("SerachKey1")); // Step 4: Insert data â€œDELâ€� in the field to open the
															// drop
															// down.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Step 5: Calling method to Select the station at 4th position in the dropdown
		// & print it.
		method.SelectFropDown(fromDate, Integer.parseInt(prop.getProperty("nthStationSelect")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 2)
	public static void SortonDateSelection() throws IOException, InterruptedException {
		// Step 8: Select 30 days from the current date in â€œSort on Dateâ€� (ex: if
		// today
		// is 04-08-2022 then fill it as 03-09-2022 by selecting from the calendar)
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(locaters.getProperty("Departuredate"))).click();
		int NoOfDays = Integer.parseInt(prop.getProperty("NdaysFromCurrentDate"));
		for (int i = 0; i < NoOfDays; i++)
			driver.findElement(By.xpath(locaters.getProperty("NextDateArrow"))).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 3)
	public static void GetListFromDropDowninXLS() throws IOException, InterruptedException {
		WriteXLSDdata writetoxls = new WriteXLSDdata();
		CommonMethod method = new CommonMethod();
		WebElement fromDate = driver.findElement(By.xpath(locaters.getProperty("FromStation")));
		fromDate.click();
		fromDate.clear();
		fromDate.sendKeys(prop.getProperty("SerachKey2"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Step 7: get the list of the data from the drop-down list & write it into an
		// excel file
		List<WebElement> ListofStation = driver.findElements(By.xpath(locaters.getProperty("SuggestedStation")));
		ArrayList<String> FromStationList = method.GetListFromDropDown(ListofStation);
		System.out.println("Number of Suggested Station " + FromStationList.size());
		
		writetoxls.WriteToXlsSheet(System.getProperty("user.dir") + prop.getProperty("dropdownstationFile"),
					prop.getProperty("OutFileSheetName"), FromStationList);
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 4)
	public static void CompairDropDownListToExistion() throws IOException, InterruptedException {
		// Step 7: compare list of the data from the drop-down with the existing
		// expected station name
		ReadXLSDdata readxls = new ReadXLSDdata();
		CommonMethod method = new CommonMethod();
		WebElement fromDate = driver.findElement(By.xpath(locaters.getProperty("FromStation")));
		fromDate.click();
		fromDate.clear();
		fromDate.sendKeys(prop.getProperty("SerachKey2"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> ListofStation = driver.findElements(By.xpath(locaters.getProperty("SuggestedStation")));
		ArrayList<String> FromStationList = method.GetListFromDropDown(ListofStation);
		ArrayList<String> readStationName = readxls.ReadFromXlsSheet(
				System.getProperty("user.dir") + prop.getProperty("FilewithStation"),
				prop.getProperty("TestFileSheetName"));
		for(String station:readStationName) {
			System.out.println(station);
		}

		if (readStationName.retainAll(FromStationList))
			System.out.println("Compare: Drop down list is same with existing expected station name");
		else
			System.out.println("Compare: Drop down list is not same with existing expected station name");
	}
}