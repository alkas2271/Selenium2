package Project11;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Quest1 
{
	  WebDriver driver;
	    public Alert alert;

	    @BeforeMethod
	    public void Browser() 
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Alka Singh\\eclipse-workspace\\1stSelenium\\src\\main\\resources\\chromedriver1.exe");
	        driver = new ChromeDriver();
	        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }

	    @Test
	    public void enter_and_fetch_some_data_on_an_alert_popup_Dismiss_Accept()
	    {
	        WebElement name_input = driver.findElement(By.xpath("//input[@id='name']"));
	        driver.findElement(By.id("alertbtn")).click();
	        alert = driver.switchTo().alert();
	        String alert_text = alert.getText();
	        System.out.println("The alert text is" + alert_text);
	        Assert.assertEquals(alert_text, "Hello , share this practice page and share your knowledge");
	        alert.dismiss();
	        name_input.sendKeys("Alka");
	        driver.findElement(By.id("alertbtn")).click();
	        alert = driver.switchTo().alert();
	        String alert_text1 = alert.getText();
	        System.out.println("The alert text is" + alert_text1);
	        Assert.assertTrue(alert_text1.contains("Alka"));
	        alert.accept();
	    }

	    @AfterMethod
	    public void Close()
	    {
	        driver.quit();
	    }

}
