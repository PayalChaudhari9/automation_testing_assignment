package signupPage_validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SpecialCharactersInName {

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
        String verificationCode = "985282"; // Valid verification code
        verificationCodeField.sendKeys(verificationCode);
       
        WebElement verifyCodeButton = driver.findElement(By.xpath("//div[text()='Verify Code']"));
        verifyCodeButton.click();
        
        String signUpPageTitle = "signUp";
        String actual_title = driver.getTitle();
        
        if (actual_title.contains(signUpPageTitle)) {
            System.out.println("Code verified!");
            System.out.println("You are at SignUp page");
            
            WebElement firstNameField = driver.findElement(By.xpath("(//input[@name='firstName'])[4]"));
            String firstName = "Pay@l!"; // Special characters in first name
            firstNameField.sendKeys(firstName);
            
            WebElement lastNameField = driver.findElement(By.xpath("(//input[@name='lastName'])[4]"));
            String lastName = "Ch@udhari#"; // Special characters in last name
            lastNameField.sendKeys(lastName);
            
            // Check for special characters in first name
            if (firstName.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                System.out.println("First name cannot contain special characters.");
            }
            
            // Check for special characters in last name
            if (lastName.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                System.out.println("Last name cannot contain special characters.");
            }
            
            // Proceed only if names are valid
            if (!firstName.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*") && 
                !lastName.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
                
                WebElement passwordField = driver.findElement(By.xpath("(//input[@name='password'])[4]"));
                String password = "Payal@123"; // Password
                passwordField.sendKeys(password);
                
                WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@name='password-confirmpassword']")); // Adjust the locator as necessary
                confirmPasswordField.sendKeys(password); // Enter the same password for confirmation
                
                // Check if password and confirm password match
                if (password.equals(confirmPasswordField.getAttribute("value"))) {
                    WebElement registerButton = driver.findElement(By.xpath("//div[text()='Register']"));
                    registerButton.click();
                    System.out.println("Account created successfully!");
                } else {
                    System.out.println("Passwords do not match. Please try again.");
                }
            } else {
                System.out.println("Please correct the names and try again.");
            }
        } else {
            System.out.println("Invalid or expired verification code");
            System.out.println("You are not at SignUp page");
        }
        
        driver.quit();
    }
}
