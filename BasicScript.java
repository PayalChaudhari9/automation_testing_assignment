package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScript {

	public static void main(String[] args) {
		
		//first we need to go to the browser
		WebDriver driver = new ChromeDriver();
		
		//After maximize the the window
		driver.manage().window().maximize();
		
		try {
            // Navigate to the noKodr platform
            driver.get("https://app-staging.nokodr.com/");

            // This is just to see the page for 6 seconds
            Thread.sleep(6000); 

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // At the end closing the browser
            driver.close(); //Here we can use driver.quit() as well
        }
	}
}
