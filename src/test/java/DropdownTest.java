import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTest{
    String innerTextFromElOfDropdown;

    @Test
    public void checkDropdownElementsForSelectingWithoutSelectWrap(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        List<WebElement> options = driver.findElement(By.id("dropdown")).findElements(By.tagName("option"));
        assertEquals(options.size(), 3, "В выпадающем списке не 3 элемента");

        dropdown.click();
        options.get(1).click();
        innerTextFromElOfDropdown = options.get(1).getAttribute("innerText");
        assertEquals(options.get(1).getAttribute("selected"), "true", "Элемент " + innerTextFromElOfDropdown + " не выбран");

        dropdown.click();
        options.get(2).click();
        innerTextFromElOfDropdown = options.get(2).getAttribute("innerText");
        assertEquals(options.get(2).getAttribute("selected"), "true", "Элемент " + innerTextFromElOfDropdown + " не выбран");
    }
}
