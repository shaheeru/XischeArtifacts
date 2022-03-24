package tamm.testcase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tamm.pageobjects.PageObject_AbuDhabiGovernmentEntities;
import tamm.pageobjects.PageObject_Home;
import tamm.utils.Browser;

public class TC_2 {
	
	String url ="https://www.tamm.abudhabi";     //URL required for Testcase2
	
	@Test
	public void t_02() throws InterruptedException {
		WebDriver driver = Browser.getDriver("Chrome");
		
		driver.get(url);
		
		//Calling all methods from PageObject class of Home Page
		PageObject_Home homepage = PageFactory.initElements(driver, PageObject_Home.class);
		homepage.ClickOnBurgerMenu();
		
		homepage.ClickOnAbuDhabiLinkText();
		
		
		
		
		//Calling all methods from PageObject class of Abu Dhabi Govt Entities page
		PageObject_AbuDhabiGovernmentEntities abudhabipage = PageFactory.initElements(driver, PageObject_AbuDhabiGovernmentEntities.class);
		
		abudhabipage.SearchInAbuDhabiSearchBox();
		
		abudhabipage.GetTotalResultsOfSeach();
		
		abudhabipage.VerifyResultsHavingADP();
		
		abudhabipage.SelectAbuDhabiPoliceFromSuggestion();
		
		abudhabipage.VerifyTotalResultsAfterSelectingAbuDhabiPolice();
				
		driver.quit();
}
}