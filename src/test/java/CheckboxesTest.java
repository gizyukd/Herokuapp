import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CheckboxesTest extends BaseTest{
    @Test
    public void checkboxes(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        assertFalse(checkboxes.get(0).isSelected(), "Чекбокс 1 активирован");
        assertTrue(checkboxes.get(1).isSelected(), "Чекбокс 2 неактивирован");

        checkboxes.get(0).click();
        assertTrue(checkboxes.get(0).isSelected(), "Чекбокс 1 неактивирован");

        checkboxes.get(1).click();
        assertFalse(checkboxes.get(1).isSelected(), "Чекбокс 2 активирован");
    }
}
