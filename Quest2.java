package Project11;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Quest2 
{
	 static WebDriver driver;

	    @BeforeClass
	    public void Initialize() 
	    {
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\Alka Singh\\eclipse-workspace\\1stSelenium\\src\\main\\resources\\chromedriver1.exe");
	        driver = new ChromeDriver();
	        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void RadioButtons()
	    {
	        List<WebElement> RadioBtn = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']"));
	        System.out.println("Size of Radio buttons is " + RadioBtn.size());
	        RadioBtn.get(0).click();
	        Assert.assertTrue(RadioBtn.get(0).isSelected());
	    }

	    @Test
	    public void DropDown() 
	    {
	        WebElement Searchbtn = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
	        Searchbtn.click();
	        List<WebElement> from = driver.findElements(By.xpath("(//div[@id='dropdownGroup1'])[1]//li"));
	        from.get(36).click();
	        List<WebElement> to = driver.findElements(By.xpath("(//div[@id='dropdownGroup1'])[2]//li"));
	        to.get(10).click();
	    }

	    @AfterClass
	    public void close()
	    {
	        driver.close();
	    }

}
