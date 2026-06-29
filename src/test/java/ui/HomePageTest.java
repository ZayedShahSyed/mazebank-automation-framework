package ui;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void isHomePageVisible(){
        Assert.assertEquals(getDriver().findElement(By.xpath("//section[@class='hero']/descendant::h1")).getText(),"Welcome to MazeBank");
    }

}
