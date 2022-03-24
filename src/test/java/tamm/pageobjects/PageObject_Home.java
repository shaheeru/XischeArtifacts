package tamm.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;



public class PageObject_Home {
	
	WebDriver driver;

	public PageObject_Home(WebDriver driver) {
		this.driver = driver;
	}
	
	//ELEMENTS
	
	//Link text to convert to english
	@FindBy(linkText = "English")
	private WebElement english_text;
	
	//search box on the home page
	@FindBy(xpath = "(//input[@name='q'])[2]")
	private WebElement search_box; 
	
	//hamburger menu on the home page
	@FindBy(xpath = "//a[@class='TPN-header__action-burger-btn']")
	private WebElement burgermenu_button;
	
	//Abudhabi govt Entities link text in the burger menu
	@FindBy(linkText = "Abu Dhabi Government Entities")
	private WebElement abudhabi_linktext;
	
	
	//METHODS
	
	//Method too change arabic to english
	public void ClickEnglishTextLink() {
		english_text.click();
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://www.tamm.abudhabi/en";
		Reporter.log("Clicked on English Text", true);
		Assert.assertEquals(actual_url, expected_url,"App did not change to English");
		Reporter.log("App changed to English version", true);
	}
	
	//Method to search for ADP in the Search Box
	public void SearchForText() throws InterruptedException {
		search_box.sendKeys("Abudhabi Police",Keys.ENTER);
		Thread.sleep(13000); //Sleep so that title and URL get updated
		Reporter.log("Searched for Abudhabi Police", true);
		String actual_title = driver.getTitle();
		String expected_title = "TAMM - Search Results - Abudhabi Police";
		Assert.assertEquals(actual_title, expected_title, "App did not search for a keyword");
		Reporter.log("Got successful results for Abudhabi Police", true);
		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://www.tamm.abudhabi/en/searchresults?q=Abudhabi+Police";
		Assert.assertEquals(actual_url, expected_url, "URL did not update, search did not navigate");
		Reporter.log("URL updated according to the search", true);
		
	}
	
	//Method to click on the hamburger menu
	public void ClickOnBurgerMenu() {
		burgermenu_button.click();
		Reporter.log("Clicked on the Hamburger Menu", true);
	}
	
	//Method to click on the abuDhabi Link text
	public void ClickOnAbuDhabiLinkText() throws InterruptedException {
		abudhabi_linktext.click();
		String actual_url = driver.getCurrentUrl();
		String expected_url= "https://www.tamm.abudhabi/en/abu-dhabi-government-entities";
		Assert.assertEquals(actual_url, expected_url, "App has not redirected to Abu Dhabi Government Entities page");
		Reporter.log("Clicked on Abu Dhabi Government Entities", true);
		Thread.sleep(7000); //Sleep so that the page gets navigated properly  
		
	}

	}
	
	
