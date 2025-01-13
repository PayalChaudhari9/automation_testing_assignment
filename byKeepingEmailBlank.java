package loginPage_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class byKeepingEmailBlank {
    public static void main(String[] args) {
        // Setting up WebDriver and go to the login page
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS); 

        // Step 1: Open the Application URL
        driver.get("https://app-staging.nokodr.com/");

        // Step 2: Leave email and password fields blank
        driver.findElement(By.name("username")).sendKeys(""); // Blank username
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Payal@888"); 

        // Step 3: Click on checkbox 
        driver.findElement(By.id("rememberMe")).click();

        // Step 4: Click on the 'Login' button
        driver.findElement(By.xpath("//div[text()='Log In']")).click(); 

        // Verify if the appropriate error messages are displayed
        String usernameErrorMessage = driver.findElement(By.xpath("//h2[text()='Please enter email']")).getText(); // Update with actual ID for username error messag

        System.out.println(usernameErrorMessage);

        // Verify mandatory fields
        String username = driver.findElement(By.name("username")).getAttribute("value");
        String password = driver.findElement(By.xpath("//input[@name='password']")).getAttribute("value");

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
