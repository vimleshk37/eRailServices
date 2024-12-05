package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties locaters = new Properties();
	public static FileReader fr1;
	public static FileReader fr2;

	@BeforeClass
	public void setup() throws IOException{

		fr1= new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\configfiles\\config.properties");
		fr2= new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\configfiles\\locators.properties");
		prop.load(fr1);
		locaters.load(fr2);

		if(prop.getProperty("browser")=="chrome");{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
		System.out.println("Browser is closed");
	}

}
