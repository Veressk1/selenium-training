package selenium.module4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
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
        List<WebElement> leftElementsList = driver.findElementsByCssSelector(".name");
        int size = leftElementsList.size();
        for (int i = 0; i < size; i++) {
            leftElementsList = driver.findElementsByCssSelector(".name");
            leftElementsList.get(i).click();
            driver.findElementByTagName("h1").isDisplayed();
        }
    }

    @After
    public void end() {
        driver.quit();
    }
}
