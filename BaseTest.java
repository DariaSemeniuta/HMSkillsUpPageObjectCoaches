package Test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Daria
 */
public class BaseTest extends TestCase{
    protected static WebDriver driver;
    @Before
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
        //driver.get(startPage);
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("Тест окончен!");
        driver.quit();
    }
}
