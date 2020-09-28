import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.functors.FalsePredicate;
import org.apache.commons.collections4.functors.TruePredicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestNG {

	public String url = "http://demo.guru99.com/test/newtours/";
	public WebDriver dr;
	
	
	@BeforeTest
	public void setUrl() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Gajendra\\OneDrive\\Desktop\\Selenium chrome driver\\Selenium\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	//	driver=new ChromeDriver();
		driver.get(url);
		String actualTitle1 = driver.getTitle();
		System.out.println("Actual title = "+actualTitle1);
		dr = driver;
	}
	
	@Test(groups = "smoketest")
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = dr.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Actual title = "+actualTitle);
	}
	
	@AfterTest
	public void hi() {
		dr.close();
	}
	
}
