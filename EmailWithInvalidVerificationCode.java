package signupPage_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EmailWithInvalidVerificationCode {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://app-staging.nokodr.com/");
        
        WebElement signUpLink = driver.findElement(By.linkText("Sign up"));
        signUpLink.click();
        
        WebElement emailField = driver.findElement(By.xpath("(//input['name=\"username\"'])[4]"));
        String email = "shivanichaudhari109@gmail.com"; // Valid email
        emailField.sendKeys(email);
        
        WebElement checkbox = driver.findElement(By.xpath("(//input['name=\"agreeToTerms\"'])[5]/parent::div/label/span"));
        checkbox.click();	
        
        WebElement proceedButton = driver.findElement(By.xpath("//div[text()='Proceed']"));
        proceedButton.click();
        
        WebElement messageElement = driver.findElement(By.xpath("/html/body/div[6]/section/abx-toaster/div/div"));
        String message = messageElement.getText();
        System.out.println(message);
        WebElement verificationCodeField = driver.findElement(By.xpath("(//input['placeholder=\"Enter Code\"'])[4]"));
        String invalidVerificationCode = "768*65"; // Invalid verification code
        verificationCodeField.sendKeys(invalidVerificationCode);
       
        WebElement verifyCodeButton = driver.findElement(By.xpath("//div[text()='Verify Code']"));
        verifyCodeButton.click();
        
        // Check for error message indicating invalid verification code
        try {
            WebElement errorMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'Invalid verification code')]")); // Adjust the locator as necessary
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Invalid or expired code");
        }
        
        driver.quit();
    }
}