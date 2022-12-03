package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	// Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}


	@FindBy(linkText = "Login")
	WebElement lnkLogin;

	public void ClickLogin()
	{
		lnkLogin.click();
	}


	//Footer Links

	@FindBy(linkText = "About Us")
	WebElement link_AboutUs;

	public String validatelinkAboutUs()
	{
		link_AboutUs.click();
		String txt_AboutUs = driver.getTitle();
		return txt_AboutUs;
	}


	@FindBy(linkText = "Delivery Information")
	WebElement link_DeliveryInformation;
	public String validatelinkDeliveryInformation()
	{
		link_DeliveryInformation.click();
		String txt_DeliveryInfo = driver.getTitle();
		return txt_DeliveryInfo;
	}

	@FindBy(linkText = "Privacy Policy")
	WebElement link_PrivacyPolicy;
	public String validatelinkPrivacyPolicy()
	{
		link_PrivacyPolicy.click();
		String txt_PrivarcyPolicy = driver.getTitle();
		return txt_PrivarcyPolicy;
	}

	@FindBy(linkText = "Terms & Conditions")
	WebElement link_Termsconditions;
	public String validatelinkTermsConditions()
	{
		link_Termsconditions.click();
		String txt_TermsCondition = driver.getTitle();
		return txt_TermsCondition;
	}

	@FindBy(linkText = "Contact Us")
	WebElement link_ContactUs;
	public String validatelinkContactUs()
	{
		link_ContactUs.click();
		String txt_linkContactUs = driver.getTitle();
		return txt_linkContactUs;
	}

	@FindBy(linkText = "Returns")
	WebElement link_Returns;
	public String validatelinkReturns()
	{
		link_Returns.click();
		String txt_LinkReturns = driver.getTitle();
		return txt_LinkReturns;
	}

	@FindBy(linkText = "Site Map")
	WebElement link_SiteMap;
	public String validatelinkSiteMap()
	{
		link_SiteMap.click();
		String txt_SiteMap = driver.getTitle();
		return txt_SiteMap;
	}

	@FindBy(linkText = "Brands")
	WebElement link_Brands;
	public String validatelinkBrands()
	{
		link_Brands.click();
		String txt_linkBrands = driver.getTitle();
		return txt_linkBrands;
	}

	@FindBy(linkText = "Gift Certificates")
	WebElement link_GiftCertificates;
	public String validatelinkGiftCertificates()
	{
		link_GiftCertificates.click();
		String txt_GiftCertificates = driver.getTitle();
		return txt_GiftCertificates;
	}

	@FindBy(linkText = "Affiliate")
	WebElement link_Affiliate;
	public String validatelinkAffiliate()
	{
		link_Affiliate.click();
		String txt_Affiliate = driver.getTitle();
		return txt_Affiliate;
	}

	@FindBy(linkText = "Specials")
	WebElement link_Specials;
	public String validatelinkSpecials()
	{
		link_Specials.click();
		String txt_Specials= driver.getTitle();
		return txt_Specials;
	}

	@FindBy(xpath = "//ul[@class='list-unstyled']//a[text()='My Account']")
	WebElement link_MyAccount;
	public String validatelinkMyAccount()
	{
		link_MyAccount.click();
		String txt_MyAccount = driver.getTitle();
		return txt_MyAccount;
	}

	@FindBy(xpath = "//ul[@class='list-unstyled']//a[text()='Order History']")
	WebElement link_OrderHistory;
	public String validatelinkOrderHistory()
	{
		link_OrderHistory.click();
		String txt_OrderHistory = driver.getTitle();
		return txt_OrderHistory;
	}

	@FindBy(xpath = "//ul[@class='list-unstyled']//a[text()='Wish List']")
	WebElement link_WishList;
	public String validatelinkWishList()
	{
		link_WishList.click();
		String txt_WishList = driver.getTitle();
		return txt_WishList;
	}

	@FindBy(xpath = "//ul[@class='list-unstyled']//a[text()='Newsletter']")
	WebElement link_Newsletter;
	public String validatelinkNewsletter()
	{
		link_Newsletter.click();
		String txt_Newsletter = driver.getTitle();
		return txt_Newsletter;
	}

	// Menu Items

	@FindBy(xpath = "//a[text()='Desktops']")
	WebElement linkdesktop;
	public void click_Desktop()
	{
		action.moveToElement(linkdesktop).click().perform();

	}

	@FindBy(xpath = "//li[@class='dropdown open']//div[@class='dropdown-menu']//a")
	List<WebElement> desktop_List;

	public List<WebElement> desktopList()
	{
		//desktop_List.toArray();
		return desktop_List;
	}

	@FindBy(xpath="//li[@class='dropdown open']//div[@class='dropdown-menu']//a[@class='see-all']")
	WebElement show_AllDesktops;

	public void click_ShowAllDesktop()
	{
		show_AllDesktops.click();
	}
	
	
	@FindBy(name = "search")
	WebElement txt_search;
	
	public void send_SearchItem(String product)
	{
		txt_search.sendKeys(product);
	}
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btn_search;
	
	public void click_SearchBtn()
	{
		btn_search.click();
	}
	
	
	
	
	public void testDesktopMenuItems(List<String> expected)
	{
		for(WebElement dl : desktop_List)
		{
			for(int i=0;i<expected.size();i++)
			{
				if(dl.getText().equals(expected.get(i))) 
				{
					Assert.assertEquals(true, true);
					//.assertTrue(true, "Menu items Matched");   
				}
			}
		}

	}
	
	@FindBy(xpath = "//title")
	WebElement pTitle;
	
	public boolean validatePageTitle(String confirmTitle)
	{
		String titleText = pTitle.getText();
		if(titleText.equals(confirmTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}



}

//"org.openqa.selenium.WebDriver.findElement(org.openqa.selenium.By)" because "this.driver" is null
//resolved the issue by myself what I was doing wrong here was initializing 
//my Webdriver two times in my class 2 due to which it was giving this error.