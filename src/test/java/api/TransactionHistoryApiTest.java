package api;

import api.models.TransactionHistoryResponse;
import api.services.TransactionHistoryService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionHistoryApiTest {

    TransactionHistoryService transactionHistoryService = new TransactionHistoryService();
    TransactionHistoryResponse[] transactionHistoryResponse;

    @Test
    public void getTransactionHistory(){
        Response res = transactionHistoryService.getTransactionHistory();
        transactionHistoryResponse = res.as(TransactionHistoryResponse[].class);
        Assert.assertTrue(transactionHistoryResponse.length>0);
    }


    @Test
    public void getAllTransactionsAsAdmin(){
        Response res = transactionHistoryService.getAllTransactions();
        System.out.println(res.then().statusCode(200));
        transactionHistoryResponse = res.as(TransactionHistoryResponse[].class);
        Assert.assertTrue(transactionHistoryResponse.length>0);
    }
}
