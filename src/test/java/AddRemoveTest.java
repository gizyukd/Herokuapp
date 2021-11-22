import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveTest extends BaseTest{
    String deleteButtonLocator = "[onclick='deleteElement()']";

    @Test
    public void addRemoveElements(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.cssSelector("[onclick='addElement()']"));
        addButton.click();
        addButton.click();

        List<WebElement> deleteButtons = driver.findElements(By.cssSelector(deleteButtonLocator));
        assertEquals(deleteButtons.size(), 2, "Кол-во эл-ов != 2");

        deleteButtons.get(1).click();
        deleteButtons = driver.findElements(By.cssSelector(deleteButtonLocator));
        assertEquals(deleteButtons.size(), 1, "Кол-во эл-ов != 1");
    }
}
