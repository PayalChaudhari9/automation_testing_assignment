package forgotPassword_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UsingRegisteredPhone {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://app-staging.nokodr.com/");
        
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password?"));
        forgotPasswordLink.click();
        
        WebElement phoneOption = driver.findElement(By.xpath("(//span[text()=' Phone '])[2]")); // Adjust the locator as necessary
        phoneOption.click();
        WebElement phoneField = driver.findElement(By.xpath("(//input['name=\"username\"'])[5]"));
        if (phoneField.isDisplayed()) {
            System.out.println("Phone field is present.");
        } else {
            System.out.println("Phone field is not present.");
            driver.quit();
            return;
        }
        
        String phone = "7888251521"; // valid registered phone number
        phoneField.sendKeys(phone);
        
        if (!phone.matches("^[0-9]{10}$")) { // Simple validation for a 10-digit phone number
            System.out.println("Invalid phone number format.");
            driver.quit();
            return;
        }
      
        WebElement proceedButton = driver.findElement(By.xpath("//div[text()='Proceed']")); 
        proceedButton.click();
        
        try {
            WebElement successMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'Reset link sent to your phone')]")); // Adjust the locator as necessary
            String successMessage = successMessageElement.getText();
            System.out.println(successMessage);
            System.out.println("Reset link sent to your phone");
        } catch (Exception e) {
            try {
                WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'Phone number not registered')]")); // Adjust the locator as necessary
                String errorMessage = errorMessageElement.getText();
                System.out.println(errorMessage);
            } catch (Exception ex) {
                System.out.println("User  does not exist.");
            }
        }
        
        driver.quit();
    }
}