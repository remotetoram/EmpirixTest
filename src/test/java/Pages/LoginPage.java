package Pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	public static String currentLanguage="Japanese";	
	By username= By.xpath("//input[@type='text']");
	By dashboard=By.xpath("//*[@class='active mactive']//a[text()='Dashboard']");
	By password= By.xpath("//input[@type='password']");
	By submit	=By.xpath("//input[@type='submit']");
	By cookiesBtn=By.xpath("//div[@class='cc-compliance']//*[@role='button']");
	
	/*This Page class contains controls present on this webpage 
	   and methods which are executed by those controls
	   */
	
	   public LoginPage(WebDriver driver) {
		this.driver=driver;
	    }
		
	public void clickLogin()
	{
	driver.findElement(submit).click();
	}	
	
	 public void login(String strUserName,String strPasword) throws InterruptedException{
		 driver.findElement(username).sendKeys(strUserName);
		 driver.findElement(password).sendKeys(strPasword);
		 driver.findElement(submit).click();
		 WebDriverWait wait = new WebDriverWait(driver,1000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='logo']")));
		 System.out.println(currentLanguage);
		 Thread.sleep(50000);
		 driver.findElement(cookiesBtn).click();
		 if(driver.findElements(dashboard).isEmpty()==false){
			 LoginPage.currentLanguage="English";	 
		}
		 System.out.println("now  language become"+currentLanguage );
       }
	
	public String getTitle() {
		 String title=driver.getTitle();
		  System.out.println(title);
		  return title;
	}
 
}
