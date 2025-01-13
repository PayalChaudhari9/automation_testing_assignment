package signupPage_validation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignupWithGoogle {

public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.get("https://app-staging.nokodr.com/");
        
        WebElement signUpLink = driver.findElement(By.linkText("Sign up"));
        signUpLink.click();
        
        //clicking on signUp with google option
       driver.findElement(By.xpath("//div[text()='Sign up With Google']")).click();
       driver.findElement(By.xpath("//input['aria-label=\"Email or phone\"']")).sendKeys("pmchaudhari910@gmail.com");
       driver.findElement(By.xpath("//span[text()='Next']")).click();
       
      
        driver.quit();
    }
}

