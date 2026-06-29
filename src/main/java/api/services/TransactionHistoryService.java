package api.services;

import api.payloads.LoginRequestPayload;
import io.restassured.response.Response;
import utils.UserManager;

import static io.restassured.RestAssured.given;

public class TransactionHistoryService extends BaseService {
    LoginRequestPayload loginRequestPayload = new LoginRequestPayload("lala@gmail.com","Password@123");

    UserManager userManager;

    public TransactionHistoryService(){
        if(userManager==null){
            userManager = generateToken(loginRequestPayload);
        }
    }

    public Response getTransactionHistory(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+userManager.getToken())
                .pathParams("customerid",userManager.getCustomerId())
                .when()
                .get("transactions/customer/{customerid}");

        return res;
    }


    public Response getAllTransactions(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer "+generateAdminToken())
                .when()
                .get("admin/transactions");
        return res;

    }

}
