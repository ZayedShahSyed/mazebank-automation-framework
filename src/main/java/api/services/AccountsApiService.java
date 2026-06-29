package api.services;

import io.restassured.response.Response;
import api.payloads.LoginRequestPayload;
import utils.UserManager;

import static io.restassured.RestAssured.given;

public class AccountsApiService extends BaseService{

    LoginRequestPayload loginRequestPayload = new LoginRequestPayload("lala@gmail.com","Password@123");
    UserManager userManager;

    public AccountsApiService(){
        if(userManager==null){
            userManager = generateToken(loginRequestPayload);
        }
    }

    public Response accounts(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+userManager.getToken())
                .when()
                .get("accounts/customer/"+userManager.getCustomerId());
        return res;
    }


}
