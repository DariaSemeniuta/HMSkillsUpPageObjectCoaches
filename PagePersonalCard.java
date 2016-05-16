package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Daria
 */
public class PagePersonalCard {
    private final WebDriver driver;
    private By name = By.className("greenHeader");
    private String pathToCard = "//div[@class='team-list clearfix']/div[@class='member']/a/span[contains(text(),'";
    private WebElement element;
    private By pathToListCourses = By.xpath("//div [@class='text']/ul/li");
    public PagePersonalCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void goToCard(String coachName) throws Exception{
        element=driver.findElement(By.xpath(pathToCard+coachName+"')]"));
        element.click();
    }
    public String findNameHeader() throws Exception{
        element=driver.findElement(name);
        return element.getText();
    }
    public String findCourses () throws Exception{
        String listCourses = "";
        try {
            List<WebElement> courses = driver.findElements(pathToListCourses);
            for (WebElement i : courses)
                listCourses = listCourses + i.getText() + " ";
        }
        catch ( NoSuchElementException e){
            listCourses="";
        }
        return listCourses;
    }
}
