package tamm.testcase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import tamm.pageobjects.PageObject_Home;
import tamm.pageobjects.PageObject_Search;
import tamm.utils.Browser;

public class TC_1 {
	
	
	String url ="https://www.tamm.abudhabi/ar-AE/";
	@Test
	public void t_01() throws InterruptedException {
		WebDriver driver = Browser.getDriver("Chrome");
		
		driver.get(url);
		
		//Calling all methods from PageObject class of Home Page
		PageObject_Home homepage = PageFactory.initElements(driver,PageObject_Home.class);
		
		
		homepage.ClickEnglishTextLink(); //Method to change language to English
		
		homepage.SearchForText(); //search for Keyword Abudhabi Police
		
		//Calling all methods from PageObject class of Search page
		PageObject_Search searchpage = PageFactory.initElements(driver,PageObject_Search.class);
		
		
		searchpage.GetCount(); //Get count
		
		searchpage.GetFirstFiveRecords(); //get first 5
		
		searchpage.refreshfivetimes(); //refresh 5 times
		
		driver.quit();
		
		}
	

}
