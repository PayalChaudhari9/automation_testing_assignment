package loginPage_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnregisteredMobileWithOtp {
    public static void main(String[] args) {
        // Setting up WebDriver and go to the login page
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS); 

        // Open the Application URL
        driver.get("https://app-staging.nokodr.com/");
        
        driver.findElement(By.xpath("//span[text()=' OTP ']")).click();

        //Click on the option to use mobile number for login
        driver.findElement(By.xpath("//span[text()=' Phone ']")).click();

        //Enter an unregistered mobile number
        driver.findElement(By.xpath("(//input['name=\"username\"'])[2]")).sendKeys("9876755432"); 

        driver.findElement(By.xpath("//div[text()='Send Code']")).click();
        String errorMessage = driver.findElement(By.xpath("//h2[text()='User not found']")).getText(); 
        System.out.println(errorMessage); 
        //Click on the 'Login' button
        driver.findElement(By.xpath("//button[text()='Log In']")).click(); 

        // Verify if the appropriate error message is displayed for unregistered mobile number
        errorMessage = driver.findElement(By.id("mobileErrorMessage")).getText(); 
        System.out.println(errorMessage); 

        // Close the browser
        driver.quit();
    }
}
