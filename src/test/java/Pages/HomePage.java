package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
  WebDriver driver;
  By userDdn=By.xpath("//*[contains(@class,'dropdown-toggle')]");
  By japaneseLang =By.xpath("//*[text()='Japanese']");
  By englishLang =By.xpath("//*[text()='English']");
  
  By dashboardTab=By.xpath("//li//a[@href='/dashboard']");
  By alertsTab=By.xpath("//li//a[@href='/alerts']");
  By testsTab=By.xpath("//li//a[@href='/tests']");
  By variablesTab=By.xpath("//li//a[@href='/variables']");
  By notificationsTab=By.xpath("//li//a[@href='/notifi']");
  By dashboard=By.xpath("//*[@class='active mactive']//a[text()='Dashboard']");
  By clientLink=By.xpath("//*[text()='Client']");
  By clientLabel=By.xpath("//label[text()='Empirix_QA_Training']");

  
  /*This Page class contains controls present on this webpage 
   and methods which are executed by those controls
   */
  
  
    public HomePage(WebDriver driver){
	this.driver=driver;
	}

  public String selectLanguage(String newLanguage){
	String currentLanguage="Japanese";
	if(driver.findElements(dashboard).isEmpty()==false){
		 currentLanguage="English";	 
	}
	if(currentLanguage.equalsIgnoreCase(newLanguage)){
		return currentLanguage;
	}
	if(newLanguage.equalsIgnoreCase("Japanese")){
		driver.findElement(userDdn).click();
		driver.findElement(japaneseLang).click();
		Alert alert = driver.switchTo().alert();
        alert.accept();
        currentLanguage="Japanese";
        WebDriverWait wait = new WebDriverWait(driver,80000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='logo']")));
		return currentLanguage;
	}
     if(newLanguage.equalsIgnoreCase("English")){
    	driver.findElement(userDdn).click();
		driver.findElement(englishLang).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
        currentLanguage="English";
        WebDriverWait wait = new WebDriverWait(driver,80000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='logo']")));
        return currentLanguage;
	}
     
	return newLanguage;

}
public String checkLanguage()
{
	String currentLanguage="Japanese";
	 if(driver.findElements(dashboard).isEmpty()==false)
	 {
		 currentLanguage="English";	 
		 return currentLanguage;
	 }
	return currentLanguage; 
}
     public void changeTab(int i)
     {
     
      switch(i){
      case 1:
      driver.findElement(dashboardTab).click();
      break;
      case 2:
      driver.findElement(alertsTab).click();
      break;

      case 3:
      driver.findElement(testsTab).click();
      break;	

      case 4:
      driver.findElement(variablesTab).click();
      break;	

      case 5:
      driver.findElement(notificationsTab).click();
      break;	

     }	
     }

     public void selectfromProfileDdn(String optionValue)
     {
      optionValue=optionValue.toUpperCase();
      switch(optionValue){
	  case "CLIENT":
	  driver.findElement(userDdn).click();
	  driver.findElement(clientLink).click();
	  WebDriverWait wait = new WebDriverWait(driver,80000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(clientLabel));
      }
     }
     public boolean verifylabel(String labelName){
		String clientLabelActual = driver.findElement(clientLabel).getText();
    	 if(clientLabelActual.equalsIgnoreCase(labelName)){
    	 return true;
    	 }
    	 return false;
    
     }
     
     

}

