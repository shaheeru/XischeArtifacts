package tamm.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class PageObject_Search {

	WebDriver driver;
	String count_total;
	List<String> list = new ArrayList<String>();
	
	public PageObject_Search(WebDriver driver) {
		this.driver = driver;
	}
	
//ELEMENTS	
	
	@FindBy(xpath = "//p[@class='totalResultsText']")
	private WebElement count; 
	
	
	@FindBy(xpath = "(//h4[@class='ui-lib-link__heading ui-lib-bold'])")
	private List<WebElement> abc;
	
	
	
//METHODS
	
	//Method to get the total count of the result
	public void GetCount() {
		count_total = count.getText();
		System.out.println(count_total);	
	}
	
	//Method to store the first five results of the search in list
	public void GetFirstFiveRecords() {
		for (int i=0;i<5;i++) {
			String result_text=abc.get(i).getText();
			list.add(result_text);
		}
	}
	
	//Method to refresh page five times, store results and compare with previous list
	public void refreshfivetimes() {
		String checkresultbefore = "all items present";
		String checkresultafter = "dummy";
		
		for (int i=1;i<6;i++) {
			driver.navigate().refresh();
			String actual_count = count.getText();
			Assert.assertEquals(actual_count, count_total,"count not equal");
			List<String> newlisting = new ArrayList<String>();
			System.out.println("Refresh iteration number " + i);
			for (int j=1;j<6;j++) {
				String newlistitem=driver.findElement(By.xpath("(//h4[@class='ui-lib-link__heading ui-lib-bold'])[" + j + "]")).getText();
				
				newlisting.add(newlistitem);
				
					if (list.contains(newlistitem) != true) {
						System.out.println("item not in the list");
				}
				
			}
		 			if(newlisting.equals(list)) {
		 				checkresultafter = "all items present";
		 				System.out.println("List Verified, After " + i + " refreshes, list items are equal");
		 			}else {
		 				checkresultafter = "not equal";
		 				System.out.println("Search Items did not remain equal in 5 refreshes");
		 		}
		 	Assert.assertEquals(checkresultbefore, checkresultafter, "Results of lists don't match");
		 	}
		Reporter.log("\n Lists verified for items equal during all 5 refreshes",true);
	 }
}
	
