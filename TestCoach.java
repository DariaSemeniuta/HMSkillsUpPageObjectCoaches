package Test;

import PageObject.PageCoach;
import PageObject.PagePersonalCard;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Daria
 */
public class TestCoach extends BaseTest {
    private String nameCoach1="Александр Галковский";
    private String nameCoach2="Михаил Чокан";
    private String nameCoach3="Артем Карпов";
    private PageCoach coach;
    private WebElement element;
    private PagePersonalCard card;
    @Test
    public void testGalkovskiy() throws Exception{
        coach=new PageCoach(driver);
        coach.goToCoachPage();
        assertTrue("Тренера Галковского нет!",coach.findCoaches().contains(nameCoach1));
        //assertEquals("Invalid name of coach!", );
    }
    @Test
    public void testCardGalkovskiy() throws Exception{
        coach=new PageCoach(driver);
        coach.goToCoachPage();
        card = new PagePersonalCard(driver);
        card.goToCard(nameCoach1);
        assertEquals("Invalid name in header",nameCoach1,card.findNameHeader());
        System.out.println(nameCoach1+" ведет следующие курсы: "+card.findCourses());
        assertEquals("Invalid course","Погружение в Java ",card.findCourses());
    }
    @Test
    public void testChokan() throws Exception{
        coach=new PageCoach(driver);
        coach.goToCoachPage();
        assertTrue("Тренера Чокан нет!",coach.findCoaches().contains(nameCoach2));
    }
    @Test
    public void testCardChokan() throws Exception{
        coach=new PageCoach(driver);
        coach.goToCoachPage();
        card = new PagePersonalCard(driver);
        card.goToCard(nameCoach2);
        assertEquals("Invalid name in header",nameCoach2,card.findNameHeader());
        assertEquals("Invalid course","",card.findCourses());
    }
    @Test
    public void testArtem() throws Exception{
        coach = new PageCoach(driver);
        coach.goToCoachPage();
        assertTrue("Тренера Артема нет!",coach.findCoaches().contains(nameCoach3));
    }
    @Test
    public void testCardKarpov() throws Exception{
        coach=new PageCoach(driver);
        coach.goToCoachPage();
        card = new PagePersonalCard(driver);
        card.goToCard(nameCoach3);
        assertEquals("Invalid name in header",nameCoach3,card.findNameHeader());
        System.out.println(nameCoach3+" ведет следующие курсы: "+card.findCourses());
        assertEquals("Invalid course","Автоматизация тестирования ПО ",card.findCourses());
    }

}
