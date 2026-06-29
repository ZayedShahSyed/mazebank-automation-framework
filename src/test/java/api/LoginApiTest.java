package api;

import api.models.Admin;
import api.models.Customer;
import api.services.LoginApiService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserManager;

public class LoginApiTest {
    LoginApiService loginApiService = new LoginApiService();

   UserManager customer;
    @Test
    public void login(){
        Response res = loginApiService.login();
        Assert.assertEquals(res.getStatusCode(),200);
        customer = res.as(UserManager.class);
        Assert.assertEquals(customer.getEmail(),"lala@gmail.com");
        Assert.assertEquals(customer.getRole(),"CUSTOMER");

    }

    @Test
    public void adminLogin(){
        Response res = loginApiService.adminLogin();
        Assert.assertEquals(res.getStatusCode(), 200);
        Admin admin = res.as(Admin.class);
        Assert.assertEquals(admin.getRole(),"ADMIN");
    }
}
