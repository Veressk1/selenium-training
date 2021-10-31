package selenium.module4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task8 {
    private ChromeDriver driver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @Test
    public void checkStickersTest() {
        int size = driver.findElementsByCssSelector(".product").size();
        for (int i = 0; i < size; i++) {
            int numberOfStickers = driver.findElementsByCssSelector(".product").get(i)
                    .findElements(By.cssSelector("[class^=sticker]"))
                    .size();
            assertEquals(1, numberOfStickers, "У продукта НЕ один стикер");
        }
    }

    @After
    public void end() {
        driver.quit();
    }
}
