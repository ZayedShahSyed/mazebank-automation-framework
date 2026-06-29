package api.services;

import io.restassured.response.Response;
import api.models.AccountsResponse;
import api.payloads.DepositRequestPayload;
import api.payloads.LoginRequestPayload;
import utils.UserManager;

import static io.restassured.RestAssured.given;

public class DepositService extends BaseService {
    LoginRequestPayload loginRequestPayload = new LoginRequestPayload("lala@gmail.com","Password@123");
    DepositRequestPayload depositRequestPayload;
    UserManager userManager;

    public DepositService(){
        if(userManager==null){
            userManager = generateToken(loginRequestPayload);
        }
    }

    public long getAccountId(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+userManager.getToken())
                .when()
                .get("accounts/customer/"+userManager.getCustomerId());

        return res.as(AccountsResponse[].class)[0].getId();
    }


    public Response depositAmount(){
        long accountId = getAccountId();
        depositRequestPayload = new DepositRequestPayload(accountId,1000);
        return given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+userManager.getToken())
                .body(depositRequestPayload)
                .when()
                .post("/transactions/deposit");

    }
}
