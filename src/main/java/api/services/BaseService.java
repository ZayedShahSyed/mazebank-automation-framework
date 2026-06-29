package api.services;

import api.models.Admin;
import api.payloads.AdminLoginReqPayload;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import api.payloads.LoginRequestPayload;
import utils.UserManager;

import static io.restassured.RestAssured.given;

public class BaseService {
    public UserManager userManager;
    public BaseService(){
        RestAssured.baseURI="https://mazebank-dgov.onrender.com/api/";
        RestAssured.useRelaxedHTTPSValidation();
        userManager = new UserManager();

    }

    public UserManager generateToken(LoginRequestPayload loginRequestPayload){
        Response res = loginUser(loginRequestPayload);
        userManager.setUser(res.as(UserManager.class));

        return userManager;
    }

    public Response loginUser(LoginRequestPayload loginRequestPayload){
        Response res =  given()
                .header("Content-Type","application/json")
                .body(loginRequestPayload)
                .when()
                .post("/auth/login");
        return res;
    }

    public String generateAdminToken(){
        return adminLogin().then().extract().path("token");
    }

    public Response adminLogin(){
        Response res = given()
                .header("Content-Type","application/json")
                .body(new AdminLoginReqPayload("admin","admin123"))
                .when()
                .post("auth/admin/login");

        return res;
    }




}
