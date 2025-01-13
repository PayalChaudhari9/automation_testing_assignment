package loginPage_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginByKeepingOtpBlank {
	public static void main(String[] args) {
		// Setting up WebDriver and go to the login page
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS); 

		//Open the Application URL
		driver.get("https://app-staging.nokodr.com/");
		
		//Choose OTP option
		driver.findElement(By.xpath("//span[text()=' OTP ']")).click();

		//Enter valid email and password
		driver.findElement(By.name("username")).sendKeys("pmchaudhari910@gmail.com");

		//Click on the 'Login' button
		driver.findElement(By.xpath("//div[text()='Send Code']")).click();  
		
		// Verify if the appropriate error messages are displayed
        String usernameErrorMessage = driver.findElement(By.xpath("//h2[text()='User not found']")).getText(); 
        System.out.println(usernameErrorMessage);

		//Verify if the login was successful
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("dashboard")) {
			System.out.println("Login successful, redirected to dashboard.");
		} else {
			System.out.println("Login failed, not redirected to dashboard.");
		}

		// Verify mandatory fields
		String username = driver.findElement(By.name("username")).getAttribute("value");
		String otp = driver.findElement(By.xpath("//span[text()=' OTP ']")).getAttribute("value");

		if (username.isEmpty()) {
			System.out.println("Username field is mandatory.");
		}

		// Close the browser
		driver.quit();
	}
}

