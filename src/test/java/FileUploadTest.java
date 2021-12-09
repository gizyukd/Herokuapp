import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class FileUploadTest extends BaseTest{
    @Test
    public void checkNameOfUploadedFile(){
        driver.get("http://the-internet.herokuapp.com/upload");

        File file = new File("src/test/resources/memImg.jpg");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.id("file-submit")).click();
        assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3")).getText(), "File Uploaded!", "Файл не загружен");
        assertEquals(driver.findElement(By.id("uploaded-files")).getText(), file.getName(), "Отображено неверное имя загруженного файла");
    }

}
