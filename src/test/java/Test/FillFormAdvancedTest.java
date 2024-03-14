package Test;


import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class FillFormAdvancedTest extends BaseTest
{
        
        @Test
        void fillFormAdvancedScenario()
        {
            driver = getDriver("edge");
            driver.get(appurl);
            log.info("Webdriver started");
            
            WebElement contactUsLink = driver.findElement(By.cssSelector("#contact-link a"));
            contactUsLink.click();
            log.info("Opened contact form");
            
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("xyz@xyz.xyz");
            log.info("Filled email data");
            
            WebElement orderField = driver.findElement(By.id("id_order"));
            orderField.sendKeys("x1y2z3");
            log.info("Filled order ID");
            
            WebElement dropdownList = driver.findElement(By.cssSelector("#id_contact"));
            Select select = new Select(dropdownList);
            select.selectByVisibleText("Webmaster");
            log.info("Selected Webmaster");
            
            WebElement messageField = driver.findElement(By.id("message"));
            messageField.sendKeys("siema siema siema");
            log.info("Entered message content");
            
            
            WebElement attatchFile = driver.findElement(By.id("fileUpload"));
            attatchFile.sendKeys("C:\\Recovery.txt");
            log.info("File attatched");
            
            WebElement submitButton = driver.findElement(By.id("submitMessage"));
            submitButton.click();
            log.info("Message Submitted");
            
            
            WebElement feedbackMessage = driver.findElement(By.className("alert-success"));
            String actuallMessage = feedbackMessage.getText();
            log.info("Feedback message read");
            
            String expectedMessage = "Your message has been successfully sent to our team.";
            assertThat(actuallMessage).isEqualTo(expectedMessage);
            log.info("Assertion completed");
            
            driver.quit();
            log.info("Driver disposed");
        }
        
    
    
}
