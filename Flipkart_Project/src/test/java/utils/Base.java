package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	public static final int WAITTIME = 5000;
	public void launchBrowser() {

		Properties prop = PropertyReader.readProperty();

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (prop.getProperty("Browser").equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (prop.getProperty("Browser").equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.get(prop.getProperty("URL"));

	}
	public static void captureScreenShot(String errMessage) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		String dateTime = sdf.format(date);
		String fileName = errMessage + "_" + dateTime + ".png";

		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Screenshots\\" + fileName);
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void sleep(int WAITTIME) {
		try {
			Thread.sleep(WAITTIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
