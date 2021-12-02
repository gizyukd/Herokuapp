import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest{
    @Test
    public void waitElementsTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        waitForPageLoaded();

        driver.findElement(By.xpath("//form[@id='checkbox-example']/button[text()='Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'gone!')]")));

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        int numberOfElements = driver.findElements(By.id("checkbox")).size();
        assertEquals(numberOfElements, 0, "Чекбокс присутствует на странице");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled(), "Поле ввода доступно");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'enabled!')]")));

        assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled(), "Поле ввода недоступно");
    }
}