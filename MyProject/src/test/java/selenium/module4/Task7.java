package selenium.module4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task7 {

    private ChromeDriver driver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("0b7dba1c77df25bf0");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void clickAllLeftMenuElements() {
        List<WebElement> leftElementsList = driver.findElementsByXPath(".//span[@class='fa-stack fa-lg icon-wrapper']");
        int size1 = leftElementsList.size();
        for (int i = 0; i < size1; i++) {
            leftElementsList = driver.findElementsByXPath(".//span[@class='fa-stack fa-lg icon-wrapper']");
            leftElementsList.get(i).click();
            driver.findElementByTagName("h1").isDisplayed();
            List<WebElement> leftInsideElementsList = driver.findElementsByCssSelector("[id^=doc-]");
            int size2 = leftInsideElementsList.size();
            for (int j = 0; j < size2; j++) {
                leftInsideElementsList = driver.findElementsByCssSelector("[id^=doc-]");
                leftInsideElementsList.get(j).click();
                driver.findElementByTagName("h1").isDisplayed();
            }
        }
    }

    @After
    public void end() {
        driver.quit();
    }
}
