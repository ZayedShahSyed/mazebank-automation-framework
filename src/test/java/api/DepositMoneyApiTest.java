package api;


import api.services.DepositService;
import org.testng.annotations.Test;


public class DepositMoneyApiTest {

    @Test
    public void testStatusCode(){
        DepositService depositService = new DepositService();
        depositService.depositAmount()
                .then()
                .statusCode(201);
    }
}
