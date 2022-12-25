package StepDef;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class BearClass {
	public  WebDriver driver;
	public static  ExtentReports reports;
	public static ExtentTest test;
	public Date d;
	int bearcolor_count;
	int count;
	String str;
	String[] arrstr;
	int ccount,rcount;
	boolean b;
	String miscat;
	List<WebElement> catCount;
	public BearClass()
	{
		driver=hooks.driver;
		
	}
	@Given("user navigates to url")
	public void user_navigates_to_url() {
	    // Write code here that turns the phrase above into concrete actions
		 d = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssZ");
		String sdate = formatter.format(d);
		
		//pro=new Properties();
		
			reports=new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\AutomationReport"+sdate+".html",false);
			test=reports.startTest("Testing Report");
			
	    driver.get("http://seleniumtableassignment.s3-website-us-west-2.amazonaws.com/");
	    test.log(LogStatus.INFO, "STARTED CHROME");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	    
	}

	@When("user user takes color from the bear table")
	public void user_user_takes_color_from_the_bear_table() {
		 test.log(LogStatus.INFO, "color test started");
	    // Write code here that turns the phrase above into concrete actions
	    List<WebElement> list=driver.findElements(By.xpath("//table[1]//tbody//tr//td[2]"));
	    bearcolor_count=list.size();
	    for(WebElement w:list)
	    {
	    	String s=w.getText();
	    	if(s.equals("Black"))
	    		count++;
	    }
	}

	@Then("Asserts the color with expected color")
	public void asserts_the_color_with_expected_color() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(count, bearcolor_count);
	    	System.out.println("All bear table rows have color in black");
	   	 test.log(LogStatus.INFO, "color test passed");
	   	 reports.flush();
	}
	
	@When("user takes  values  from the weight coloumn")
	public void user_takes_values_from_the_weight_coloumn() {
		 test.log(LogStatus.INFO, "Weight test started");
	    // Write code here that turns the phrase above into concrete actions
	 catCount = driver.findElements(By.xpath(
				"//table[@class='adap-table']//following-sibling::table//tbody//tr//child::td[contains(text(),'lbs')]"));
		for (WebElement s : catCount) {
			str = s.getText();
			arrstr = str.split(" ");
			
			if (Integer.parseInt(arrstr[0]) < 15) {
				ccount++;
			} else {
				WebElement ele=driver.findElement(By.xpath("//table[2]//td[contains(text(),'lbs')]//preceding-sibling::td[2]"));
				
				 miscat=ele.getText();
				System.out.println(miscat);
			}
		}
		

	}

	@Then("Asserts with given weight")
	public void asserts_with_given_weight() {
	    // Write code here that turns the phrase above into concrete actions
		if(catCount.size()==ccount)
		{
			System.out.println("All cats are less than 15 lb");
			
		}
		else
		{
			System.out.println("cat "+miscat+" is over 15lbs");
			 test.log(LogStatus.INFO, "one cat overweight");
		}
	  reports.flush();
	}
	@When("user take srow size and description length")
	public void user_take_srow_size_and_description_length() {
		 test.log(LogStatus.INFO, "description test started");
	    // Write code here that turns the phrase above into concrete actions
		 rcount = driver
				.findElements(By.xpath("//table[@class='adap-table']//following-sibling::table[2]//tbody//tr")).size();
		
	

	
		String s2;
		List<WebElement> starList = driver.findElements(By.xpath(
				"//table[@class='adap-table']//following-sibling::table[2]//tbody//tr//child::td[@class='description']"));
		for (WebElement s : starList) {
			s2 = s.getText();
			
			if (s2.length() < 350) {
				b = true;
			} else {
				b = false;
				break;
			}

		}
		

	}

	    
	

	@Then("Asserts it with expectded value")
	public void asserts_it_with_expectded_value() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(rcount,2);
		System.out.println("There are only two tables in starwar table");
		 test.log(LogStatus.INFO, "only two rows");
		Assert.assertTrue(b);
		System.out.println("Characters are less than 350 inlength");
		 test.log(LogStatus.INFO, "characters are less than 350");
		 reports.flush();
	  
	}




}
