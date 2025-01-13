package forgotPassword_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PhoneContainSpecialCharacters {

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
        
        String invalidPhone = "123-456-7890"; // Phone number with special characters
        phoneField.sendKeys(invalidPhone);
        
        // Proceed with the invalid phone number
        WebElement proceedButton = driver.findElement(By.xpath("//div[text()='Proceed']")); 
        proceedButton.click();
        
        try {
            // Check for error message indicating invalid phone number format
            WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'Invalid phone number format')]")); // Adjust the locator as necessary
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Please Enter valid phone number.");
        }
        
        driver.quit();
    }
}