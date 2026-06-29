package api;

import api.models.Admin;
import api.models.Customer;
import api.payloads.LoginRequestPayload;
import api.services.LoginApiService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.UserManager;

import java.io.File;
import java.io.FileReader;

public class LoginApiTest {
    LoginApiService loginApiService = new LoginApiService();

   UserManager customer;

    @Test(dataProvider = "loginDataProvider")
    public void login(LoginRequestPayload loginRequestPayload){
        Response res = loginApiService.login(loginRequestPayload);
        Assert.assertEquals(res.getStatusCode(),200);
        customer = res.as(UserManager.class);
        Assert.assertEquals(customer.getEmail(),loginRequestPayload.getEmail());
        Assert.assertEquals(customer.getRole(),"CUSTOMER");

    }

    @Test
    public void adminLogin(){
        Response res = loginApiService.adminLogin();
        Assert.assertEquals(res.getStatusCode(), 200);
        Admin admin = res.as(Admin.class);
        Assert.assertEquals(admin.getRole(),"ADMIN");
    }

    @DataProvider
    public LoginRequestPayload[][] loginDataProvider() {
        LoginRequestPayload[][] testData = null;
        try {
            File file = new File("src/test/java/testdata/loginData.json");
            FileReader fr = new FileReader(file);
            JSONTokener jt = new JSONTokener(fr);

            JSONArray jsonArray = new JSONArray(jt);
            testData = new LoginRequestPayload[jsonArray.length()][1];


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject userObj = jsonArray.getJSONObject(i);
                testData[i][0] = new LoginRequestPayload(userObj.getString("email"),userObj.getString("password"));
            }

            fr.close();
        }
        catch(Exception e) {

            // Fallback so TestNG doesn't crash with a NullPointerException immediately
            return new LoginRequestPayload[][]{};
        }

        return testData;
    }

}
