package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Daria
 */
public class PageCoach {
    public String startPage = "http://skillsup.ua/";
    public By aboutUs = By.linkText("О нас");
    public By ourTeam = By.linkText("Наша команда");
    public By path=By.className("name");
    private WebElement element;
    private final WebDriver driver;
    //private Actions action;
    public PageCoach(WebDriver driver) {
        this.driver = driver;
        driver.get(startPage);
        PageFactory.initElements(driver,this);
    }
    public String findCoaches () {
        List<WebElement> element = driver.findElements(path);
        String name="";
        for (WebElement i: element)
            name= name+i.getText()+" ";
        return name;
    }
    public  void goToCoachPage () throws  Exception{
        Actions action = new Actions(driver);
        element=driver.findElement(aboutUs);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(element);
        element=driver.findElement(ourTeam);
        action.moveToElement(element);
        action.click().build().perform();
    }
}
