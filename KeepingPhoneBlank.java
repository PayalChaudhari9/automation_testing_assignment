package forgotPassword_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KeepingPhoneBlank {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://app-staging.nokodr.com/");
        
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        
        WebElement phoneOption = driver.findElement(By.xpath("(//span[text()=' Phone '])[2]")); // Adjust the locator as necessary
        phoneOption.click();
        
        WebElement phoneField = driver.findElement(By.xpath("(//input['name=\"username\"'])[5]")); // Adjust the locator as necessary
        if (phoneField.isDisplayed()) {
            System.out.println("Phone field is present.");
        } else {
            System.out.println("Phone field is not present.");
            driver.quit();
            return;
        }
        
        // Leave the phone field blank
        String phone = ""; // No phone number entered
        phoneField.sendKeys(phone); // This line can be omitted since we're not entering anything
        
        // Proceed without entering a phone number
        WebElement proceedButton = driver.findElement(By.xpath("//div[text()='Proceed']")); 
        proceedButton.click();
        
        try {
            // Check for error message indicating that the phone number is required
            WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'Phone number is required')]")); // Adjust the locator as necessary
            String errorMessage = errorMessageElement.getText();
            System.out.println(errorMessage);
        } catch (Exception e) {
            System.out.println("Please enter phone number.");
        }
        
        driver.quit();
    }
}