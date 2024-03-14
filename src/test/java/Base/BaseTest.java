package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest
{
    public String browserName;
    public final String appurl = "http://www.automationpractice.pl/index.php?";
    public final boolean headlessBrowser = false;
    public WebDriver driver;
    
    public Logger log = LoggerFactory.getLogger(BaseTest.class);
    public WebDriver getDriver()
    {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--remote-allow-origins");
                ;
                if (headlessBrowser)
                {
                    edgeOptions.addArguments("--headless=true");
                }
                driver = new EdgeDriver(edgeOptions);
                return driver;
    }
    public WebDriver getDriver(String browserName)
    {
        switch (browserName)
        {
            case "chrome" ->
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--remote-allow-origins");
                if (headlessBrowser)
                {
                    chromeOptions.addArguments("--headless=true");
                }
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" ->
            {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--remote-allow-origins");
                if (headlessBrowser)
                {
                    firefoxOptions.addArguments("--headless=true");
                }
                driver = new FirefoxDriver(firefoxOptions);
            }
            case "edge" ->
            {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--remote-allow-origins");
                ;
                if (headlessBrowser)
                {
                    edgeOptions.addArguments("--headless=true");
                }
                driver = new EdgeDriver(edgeOptions);
            }
            default ->
            {
                System.out.println("Invalid Browser");
            }
            
        }
        return driver;
    }
}
