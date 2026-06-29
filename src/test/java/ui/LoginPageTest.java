package ui;

import base.BaseTest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.customer.LoginPage;

import java.io.File;
import java.io.FileReader;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;


    @Test(priority = 1, testName = "SMK-002",description = "Verify User Login Functionality",dataProvider = "loginDataProvider")
    public void loginWithValidDetails(String email,String password){
        loginPage=hp.navigateToLoginPage();
        logger.info("Login With Valid Details");
        loginPage.login(email,password);

        Assert.assertTrue(loginPage.isLoggedIn());
        logger.info(("Ending Valid login"));
        hp.logout();

    }

    @Test(priority = 2)
    public void loginWithInvalidDetails(){
        loginPage=hp.navigateToLoginPage();
        String text = loginPage.loginWithInvalidDetails("lala@gmail.com","password@11");
        Assert.assertFalse(text.contains("Welcome"));
        hp.navigateToHomePage();
    }



    @DataProvider(name="loginDataProvider")
    public String[][] loginDataProvider() {
        String[][] testData = null;
        try {
            File file = new File("src/test/java/testdata/loginData.json");
            FileReader fr = new FileReader(file);
            JSONTokener jt = new JSONTokener(fr);

            JSONArray jsonArray = new JSONArray(jt);
            testData = new String[jsonArray.length()][2];


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject userObj = jsonArray.getJSONObject(i);
                testData[i][0] = userObj.getString("email");
                testData[i][1] = userObj.getString("password");
            }

            fr.close();
        }
        catch(Exception e) {
            logger.warn("Unable to parse JSON File", e);
            // Fallback so TestNG doesn't crash with a NullPointerException immediately
            return new String[0][0];
        }

        return testData;
    }


}
