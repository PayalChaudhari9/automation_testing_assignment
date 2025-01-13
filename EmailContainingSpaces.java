package forgotPassword_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EmailContainingSpaces {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://app-staging.nokodr.com/");
        
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        
        WebElement emailField = driver.findElement(By.xpath("(//input['name=\"username\"'])[4]"));
        if (emailField.isDisplayed()) {
            System.out.println("Email field is present.");
        } else {
            System.out.println("Email field is not present.");
            driver.quit();
            return;
        }
        
        String invalidEmail = "shivani 56@gmail.com"; // Email with spaces
        emailField.sendKeys(invalidEmail);
        
        // Proceed with the invalid email
        WebElement proceedButton = driver.findElement(By.xpath("//div[text()='Proceed']")); 
        proceedButton.click();
        
        try {
            // Check for error message indicating invalid email format
            WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'Invalid email format')]")); // Adjust the locator as necessary
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Please enter valid email.");
        }
        
        driver.quit();
    }
}
