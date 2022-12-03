package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


	public LoginPage(WebDriver driver)
	{
		super(driver);
	}


	@FindBy(id = "input-email")
	WebElement txtEmail;


	@FindBy(id= "input-password")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;

	public void sendLoginEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void sendLoginPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}

	public void clickLoginBtn()
	{
		btnLogin.click();
	}

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	


}
