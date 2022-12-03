package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.After;
import org.junit.Assert;
//import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;
public class steps {

	WebDriver driver;
	ResourceBundle rb;
	Logger logger;
	HomePage hp;
	LoginPage lp;
	MyAccountPage ap;
	String br;
	List<HashMap<String, String>> datamap;
	
	@Before
	public void setUp()
	{
		rb= ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());
		br=rb.getString("browser");


	}

	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
		}	
		driver.quit();
	}


	@Given("user launches browser")
	public void user_launches_browser() 
	{
		if(br.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Given("opens URL {string}")
	public void opens_url(String string) 
	{
		driver.get(string);
		driver.manage().window().maximize();

	}

	@When("user clicks MyAccount link")
	public void user_clicks_my_account_link() 
	{
		hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked MyAccount link");

	}

	@When("user clicks Login link")
	public void user_clicks_login_link() 
	{

		hp.ClickLogin();
		logger.info("Clicked Login link");
	}

	@When("user enter email id {string}")
	public void user_enter_email_id(String email) 
	{
		lp = new LoginPage(driver);

		lp.sendLoginEmail(email);
		logger.info("email entered");
	}

	@When("user enter password {string}")
	public void user_enter_password(String password)
	{
		lp.sendLoginPassword(password);
		logger.info("Password entered");
	}

	@When("user clicks Login button")
	public void user_clicks_login_button()
	{
		lp.clickLoginBtn();
		logger.info("Login button got clicked");
	}

	@Then("user navigates to MyAccount")
	public void user_navigates_to_my_account() 
	{
		boolean targetPage = lp.isMyAccountPageExists();
		if(targetPage)
		{
			logger.info("Login Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login Failed");
			Assert.assertTrue(false);

		}
	}


	@Then("user navigates to MyAccountPage by passing email and password with excelrow {string}")
	public void user_navigates_to_my_account_page_by_passing_email_and_password_with_excelrow(String rows) 
	{
		String path =System.getProperty("user.dir")+"/testData/LoginDataDriven.xlsx";
	//	String path =System.getProperty("user.dir")+"/testData/LoginDataDriven.xlsx";

		datamap = DataReader.data(path, "Sheet1");
		int index=Integer.parseInt(rows)-1;
		String email= datamap.get(index).get("email");
		String pwd= datamap.get(index).get("password");
		String exp_res= datamap.get(index).get("result");


		lp=new LoginPage(driver);
		lp.sendLoginEmail(email);
		lp.sendLoginPassword(pwd);

		lp.clickLoginBtn();
		try
		{
			ap=new MyAccountPage(driver);
			boolean targetpage=ap.isMyAccountPageExists();

			if(exp_res.equals("Passed"))
			{
				if(targetpage==true)
				{
					ap.clickLogout();
				//	MyAccountPage myaccpage=new MyAccountPage(driver);
				//	myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}

			if(exp_res.equals("Failed"))
			{
				if(targetpage==true)
				{
					ap.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}


		}
		catch(Exception e)
		{

			Assert.assertTrue(false);
		}
		driver.close();
	}




}


/*
 * mistakes i did was spelling mistakes
 * stepDefinition in package and testRunner
 * importing after before from cucumber-java
 * 
 * 
 * TakesScreenshot
 * 
 * Can't find bundle for base name /Bundle, locale en_US
 * Right click on project > Properties (alt + enter) > Java Builder Path > Source > Add Folder.
 * 
 */
