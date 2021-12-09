import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest{
    @Test
    public void CheckTextUnderParagraph(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        WebDriver frame = driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        assertEquals(frame.findElement(By.xpath("//body/p")).getText(), "Your content goes here.", "В фрейме отображен неверный текст");
    }
}
