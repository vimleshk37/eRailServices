package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Readproperties {
	public static void main(String[] arg) throws IOException {
		FileReader fr = new FileReader("D:\\Automation\\OrangeHRM\\src\\test\\resources\\configfiles\\config.properties");
		Properties p = new Properties();
		p.load(fr);
		System.out.println(p.getProperty("browser"));
	}

}
