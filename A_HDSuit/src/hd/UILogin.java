package hd;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;


public class UILogin {

	
	public static WebDriver driver;
	public static WebElement userName, userPassword, loginOrRegisterButton,loginButton, workAccount,accounts[];
	public static final String baseURL = "https://qa-daily.hds.ineight.com/AppCore/Projects";
	
	//public static String browserType="";
	
	/* login : Login to the MercuryTors application
	 * 
	 * @param BROWSERTYPE
	 *            : browser to be launched to run the test cases
	 * @param USERNAME
	 *            : username to login
	 * @param password
	 *            : password to login
	 */
	@BeforeClass(alwaysRun = true)
	@Parameters({ "BROWSERTYPE", "USERNAME", "PASSWORD" })
	public static void login(String BROWSERTYPE, String USERNAME,String PASSWORD) throws Exception
	{
	if (BROWSERTYPE.equals("*firefox"))
	{
	driver = new FirefoxDriver();
	} 
	else if (BROWSERTYPE.equals("*chrome"))
	{
	System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
	driver = new ChromeDriver();
	} 
	else if (BROWSERTYPE.equals("*iexplore")) 
	{
	System.setProperty("webdriver.ie.driver","src/resources/IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	}
	
	try {
	driver.get(baseURL);
	driver.manage().window().maximize();
	Thread.sleep(500);
	driver.manage().deleteAllCookies();
	userName = driver.findElement(By.cssSelector(LocatorConstants.NAME_TEXTFIELD_LOGIN_USERNAME));
	userName.sendKeys(USERNAME);
	
	userPassword = driver.findElement(By.cssSelector(LocatorConstants.NAME_TEXTFIELD_LOGIN_PASSWORD));
	userPassword.sendKeys(PASSWORD);
	Thread.sleep(1000);
	
	List<WebElement> accounts=driver.findElements(By.cssSelector(LocatorConstants.ACCOUNT));
	accounts.get(0).click();
	driver.switchTo().alert().accept();
	driver.switchTo().alert().dismiss(); 
	loginButton = driver.findElement(By.cssSelector(LocatorConstants.NAME_BUTTON_LOGIN));
	loginButton.click();
	
	Thread.sleep(1000);
	
/*	try {
		WebDriverWait waitLoginError = new WebDriverWait(driver, 60);
		waitLoginError.until(ExpectedConditions.visibilityOfElementLocated((By
						.cssSelector(LocatorConstants.NAME_BUTTON_LOGINVERIFICATION_LINK))));
	}
	catch (TimeoutException e)
	{
		Reporter.log("Login session timed out");
	}
	
	
	
	try {
		WebElement error = driver.findElement(By.cssSelector(LocatorConstants.NAME_LABEL_LOGINERROR));
		String errorText = error.getText();
		String errorMessage = "Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help.";
		if (errorText.equals(errorMessage)) {
			Assert.assertFalse(
					errorText.equals(errorMessage),
					"Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help.");
			Reporter.log("Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help.");
			return;
		}
	} catch (NoSuchElementException e) {

		Reporter.log("No error found on login. Login is successful");
	}
	
	
	 catch (NoSuchElementException e) 
	 {
		Reporter.log("No error found on login. Login is successful");
		}
		*/
	
	


	
	
	
	/*@AfterClass
	public static void logout() throws Exception {
	driver.switchTo().defaultContent();
	try {
	WebElement menu = driver.findElement(By.linkText(LocatorConstants.NAME_BUTTON_LOGOUT));
	menu.isSelected();
	menu.click();
	} catch (NoSuchElementException e) {
	}

	driver.close();
	driver.quit();
	}

*/
	
	} catch (NoSuchElementException e) {

		Reporter.log("No error found on login. Login is successful");
	}	
	}
}
	




