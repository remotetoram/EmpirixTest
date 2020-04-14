package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import Pages.HomePage;
import Pages.LoginPage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


   /*This class contains funtion test cases which can be executed parallel on
     both(Chrome & firefox) browser.For order purpose priority is defined at test level
  */

public class functionalTests {
	  public WebDriver driver;	
	
	  @Parameters("browser")
	  @BeforeClass
  public void beforeSuite(String browser) {
		  if(browser.equalsIgnoreCase("firefox")) {
			    System.setProperty("webdriver.gecko.driver","G:/Selenium jars/geckodriver.exe");
		        driver=new FirefoxDriver();
			   }else if (browser.equalsIgnoreCase("chrome")) { 
				System.setProperty("webdriver.chrome.driver","G:/Selenium jars/chromedriver.exe");
				driver=new ChromeDriver();
		   } 
		 
	  driver.get("https://services.empirix.com/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
  
	  
	  
	  }
  @Test(priority=0)
  public void test_Home_Page_Appear_Correct() throws Exception{
   LoginPage objLogin= new LoginPage(driver);
   objLogin.login("QA_traininguser11","Empirix!");
  System.out.println("Browser is :::This one");
  //make soft assertions
   SoftAssert SA=new SoftAssert();
   SA.assertTrue(objLogin.getTitle().contains("VoiceWatch31"));
   Assert.assertTrue(objLogin.getTitle().contains("VoiceWatch"));
 }
  
  @Test(priority=2)
  public void test_Alert_Tab_VerificationEnglish(){
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(1);
 }
  @Test(priority=3)
  public void test_Tests_Tab_VerificationEnglish(){
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(3);
	    
  }
  @Test(priority=4)
  public void test_Variables_Tab_VerificationEnglish(){
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(4);
	    
  }
  @Test(priority=5)
  public void test_Notifications_Tab_VerificationEnglish() throws InterruptedException{
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(5);
	  Thread.sleep(1000);
  }
  @Test(priority=6)
  public void test_Client_Verification(){
	  HomePage objHome=new HomePage(driver);
	  objHome.selectfromProfileDdn("client");
      assertTrue(objHome.verifylabel("Empirix_QA_Training"));
   
  }
  @Parameters("browser")
  @Test(priority=7)
  public void test_change_language_Japanese(String browser)
  {
	  System.out.println("in test_change_language_Japanese(String browser) ");
	  HomePage objHome=new HomePage(driver);
	  String currentLanguage=objHome.selectLanguage("Japanese");
	  System.out.println("Language after select language : "+currentLanguage);
      Assert.assertEquals(currentLanguage.toUpperCase(), "JAPANESE");
  
      System.out.println("out test_change_language_Japanese(String browser) ");
  }	  
  @Test(priority=8)
  public void test_Notifications_Tab_VerificationJapanese() throws InterruptedException{
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(5);
	  Thread.sleep(1000);
  }
  
  @Test(priority=9)
  public void test_Alert_Tab_VerificationJapanese(){
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(2);
 }
  @Test(priority=10)
  public void test_Tests_Tab_VerificationJapanese(){
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(3);
	    
  }
  @Test(priority=11)
  public void test_Variables_Tab_VerificationJapanese(){
	  HomePage objHome=new HomePage(driver);
	  objHome.changeTab(4);
	    
  }
  @Test(priority=12)
  public void test_change_language_English()
  {
	  
	  HomePage objHome=new HomePage(driver);
	  objHome.selectLanguage("english");
      System.out.println("Now Language is : "+LoginPage.currentLanguage);
      Assert.assertEquals(LoginPage.currentLanguage.toUpperCase(), "ENGLISH");
	  }
	 
  
  @AfterSuite
  public void afterSuite() {
  }

}