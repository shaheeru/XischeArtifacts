package tamm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class PageObject_AbuDhabiGovernmentEntities {

	WebDriver driver;  //webdriver
	String total_results; //to store the text of the element
	String total_result_number; //to add just the required substring
	int i;   //to store the result int and use in loop
	
	public PageObject_AbuDhabiGovernmentEntities(WebDriver driver) {
		this.driver = driver;
	}
	

//ELEMENTS
	
	//Showing results string
	@FindBy(xpath = "//div[@class='results-count']")
	private WebElement results;
	
	//search box on Abu Dhabi Government Entities Page
	@FindBy(name = "textBoxSearch")
	private WebElement abudhabi_searchbox;
	
	//Abu Dhabi Government Entities title text on the Abu Dhabi Government Entities Page
	@FindBy(xpath = "(//h1[@class='TPN-intro__titles--page-title mb-2'])")
	private WebElement AbuDhabi_IntroTitleText;
	
	//AbuDhabi Police suggestion
	@FindBy(xpath = "(//div[@class='sugesstion-item tt-suggestion tt-selectable'])[1]")
	private WebElement AbuDhabi_Suggestion;
	
	
	
//METHODS	

	//Method to search 'ADP' in the AbuDhabi search box 
	public void SearchInAbuDhabiSearchBox() throws InterruptedException {
		abudhabi_searchbox.sendKeys("ADP",Keys.ENTER); 
		Thread.sleep(13000);  //So that page can be loaded fully
		String actual_url = driver.getCurrentUrl();
		String expected_url= "https://www.tamm.abudhabi/en/abu-dhabi-government-entities";
		Assert.assertNotEquals(actual_url, expected_url,"Did not search for anything");
		Reporter.log("Searched for ADP", true);
	}
	
	//Method to get total results after search
	public void GetTotalResultsOfSeach() {
		total_results = results.getText();  //getting text of element
		total_result_number = total_results.substring(17,18);  //extracting only the number from the string
		i = Integer.parseInt(total_result_number); //converting string to int so that it can used in loop				
		Reporter.log("Results found", true);
	}
	
	//Method to verify if the searched results have A,D,P in text
	public void VerifyResultsHavingADP() {
		for(int j=1;j<=i;j++) {  //traversing through the searched results acc to total count
			String title_info = driver.findElement(By.xpath("(//h2[@class='TPN-adge-card__Title'])[" + j + "]")).getText(); //going through elements via loop & occurences
			System.out.println(title_info);	
				if (title_info.contains("A") && title_info.contains("D") && title_info.contains("P") ) { //checking if title contains A,D,P
					System.out.println(j + "-Pass");
				}else {
					System.out.println("Fail...Does not Contain A,D and P");
						}
		}
		Reporter.log("Verified searched results for A,D,P",true);
	}
	
	//Method to select AbuDhabi Police from Suggestions
	public void SelectAbuDhabiPoliceFromSuggestion() {
		AbuDhabi_IntroTitleText.click(); //to get the suggestions we need to click elsewhere on the page first
		abudhabi_searchbox.click(); //then click back on the seachbox
		AbuDhabi_Suggestion.click(); //selecting the first item from the suggestion as it is the desired option
		Reporter.log("Clicked on the first suggetion -- Abu Dhabi Police", true);
	}
	
	//Method to verify if the total results text has changed according to the selected option
	public void VerifyTotalResultsAfterSelectingAbuDhabiPolice() throws InterruptedException {
		Thread.sleep(8000); //Sleep so that the results are updated on the page
		String actual_results = results.getText();
		Assert.assertNotEquals(actual_results, total_results,"Did not select Abu Dhabi Police");
		Reporter.log("Successfully Selected Abu Dhabi Police", true);
	}
	
}
