package StepDef;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks {
	public static WebDriver driver;
	
	@Before(order=0)
	public void beforetest() throws ClassNotFoundException, SQLException
	{
		WebDriverManager.chromedriver().setup();
	driver  =new ChromeDriver();
	
	}
	@After
	public void aftertest() throws SQLException
	{
		driver.close();
		
	}

}
