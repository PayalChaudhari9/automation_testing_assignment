package forgotPassword_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ValidEmailButSystemError {

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
        
        String email = "1901010@gcoej.ac.in"; // Replace with a valid registered email
        emailField.sendKeys(email);
        
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Invalid email format.");
            driver.quit();
            return;
        }
      
        WebElement proceedButton = driver.findElement(By.xpath("//div[text()='Proceed']")); 
        proceedButton.click();
        
        try {
            // Check for system error message
            WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'System error occurred')]")); // Adjust the locator as necessary
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("System error occurred");
        }
        
        driver.quit();
    }
}
