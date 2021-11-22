import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InputsTest extends BaseTest {
    @Test
    public void checkInputSymbols(){
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("Кириллица");
        assertEquals(input.getText(), "", "Доступен ввод кириллицы");

        input.clear();

        input.click();
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "1", "Поле не обработало ввод символа 'стрелки вверх' с клавиатуры");

        input.clear();

        input.click();
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "-1", "Поле не обработало ввод символа 'стрелки вниз' с клавиатуры");
    }
}
