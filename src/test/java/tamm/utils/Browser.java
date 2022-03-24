package tamm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;


public class Browser {
	
	public static WebDriver getDriver(String type){
		WebDriver driver = null;
		if (type.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (type.equalsIgnoreCase("firefox")) {
			//driver = new Firefox();
		}else if (type.equalsIgnoreCase("IE")) {
			//driver = new IE();
		}else {
			Assert.assertTrue(false,"No browser type sent");
		}
		
		//Browser adjustments
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

}
