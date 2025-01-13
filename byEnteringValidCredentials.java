package loginPage_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class byEnteringValidCredentials {
	public static void main(String[] args) {
		// Setting up WebDriver and go to the login page
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS); 

		// Step 1: Open the Application URL
		driver.get("https://app-staging.nokodr.com/");

		// Step 2: Enter valid email and password
		driver.findElement(By.name("username")).sendKeys("pmchaudhari910@gmail.com");
		driver.findElement(By.xpath("(//input['name=\"password\"'])[2]")).sendKeys("Payal@888");

		// Step 3: click on checkbox
		driver.findElement(By.id("rememberMe")).click();

		// Step 4: Click on the 'Login' button
		driver.findElement(By.xpath("//div[text()='Log In']")).click(); // Update with actual ID

		// Verify if the login was successful
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("dashboard")) {
			System.out.println("Login successful, redirected to dashboard.");
		} else {
			System.out.println("Login failed, not redirected to dashboard.");
		}

		// Verify mandatory fields
		String username = driver.findElement(By.name("username")).getAttribute("value");
		String password = driver.findElement(By.xpath("(//input['name=\\\"password\\\"'])[2]")).getAttribute("value");

		if (username.isEmpty()) {
			System.out.println("Username field is mandatory.");
		}
		if (password.isEmpty()) {
			System.out.println("Password field is mandatory.");
		}

		// Close the browser
		driver.quit();
	}
}
