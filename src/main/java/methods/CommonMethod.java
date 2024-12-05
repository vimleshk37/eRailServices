package methods;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CommonMethod {

	// Method to Select the station at nth position in the dropdown & print it.
	public void SelectFropDown(WebElement from, int position) {

		for (int i = 0; i < position - 1; i++)
			from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		System.out.println("Station at 4th position is selected and this is: " + from.getText());
	}

//Get the list of the data from the drop-down list and Put into Array
	public ArrayList<String> GetListFromDropDown(List<WebElement> List) {
		ArrayList<String> StationList = new ArrayList<>();
		System.out.println("Size of from station: " + List.size());
		for (WebElement element : List) {
			StationList.add(element.getAttribute("title"));
		}
		System.out.println("All list of from station is: " + StationList);
		return StationList;
	}

	public long GetEpochOfSelectedDate(int nexdateSelecter) {
		// DateTimeFormatter Hours = DateTimeFormatter.ofPattern("HH");
		// DateTimeFormatter Min = DateTimeFormatter.ofPattern("mm");
		// DateTimeFormatter Sec = DateTimeFormatter.ofPattern("ss");
		// LocalDateTime time = LocalDateTime.now();
		// String hours = Hours.format(time); String min = Min.format(time); String sec
		// = Sec.format(time);

		long now = Instant.now().getEpochSecond();
		long todaydateinEpoch = now;
		// long todaydateinEpoch = now - (Long.parseLong(hours)*3600 +
		// Long.parseLong(min)*60 + Long.parseLong(sec));
		long newdateinEpoch = (todaydateinEpoch + nexdateSelecter++ * 24 * 60 * 60) * 1000;
		return newdateinEpoch;
		// System.out.println(newdateinEpoch)
	}

}
