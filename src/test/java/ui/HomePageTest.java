package ui;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void isHomePageVisible(){
        Assert.assertEquals(hp.getLandingText(),"Welcome to MazeBank");
    }

}
