package forgotPassword_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyForgotPasswordWithRegisteredEmail {
	public static void main(String[] args) {
		// Setting up WebDriver and go to the forgot password page
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);

		// Open the Application URL
		driver.get("https://app-staging.nokodr.com/");

		// Navigate to the Forgot Password page
		driver.findElement(By.linkText("Forgot Password?")).click();

		// Enter a registered email address
		driver.findElement(By.name("username")).sendKeys("pmchaudhari910@gmail.com");

		// Click on the 'Submit' button
		driver.findElement(By.xpath("//div[text()='Proceed']")).click();

		// Verify success message
		//String successMessage = driver.findElement(By.id("successMessage")).getText();
		//System.out.println(successMessage); // Should print "Reset link sent to your email"

		String successMessage = driver.findElement(By.xpath("//h2[text()='User does not exists']")).getText();
		System.out.println(successMessage);

		// Close the browser
		driver.quit();
	}
}
