package api.models;

//{
//        "id": 224,
//        "transactionType": "DEPOSIT",
//        "amount": 1001.0,
//        "transactionDate": "2026-06-28T06:33:03.374597Z",
//        "description": "Deposit of ₹1001.0",
//        "targetAccountNumber": null,
//        "account": {
//        "id": 5,
//        "accountNumber": "MAZE17045978",
//        "accountType": "SAVINGS",
//        "aadharNumber": "998989898989",
//        "panNumber": "ABCDE1234R",
//        "balance": 1.0E97,
//        "active": true,
//        "createdAt": null,
//        "customer": {
//        "id": 7,
//        "fullName": "Lala-$d&938",
//        "email": "lala@gmail.com",
//        "phoneNumber": "9898989897",
//        "address": "",
//        "role": "CUSTOMER",
//        "createdAt": null
//        }
//        }
//        },

public class TransactionHistoryResponse {
    private long id;
    private String transactionType;
    private double amount;
    private String transactionDate;
    private String description;
    private String targetAccountNumber;
    private AccountsResponse account;


    public TransactionHistoryResponse() {
    }

    public TransactionHistoryResponse(long id, String transactionType, double amount, String transactionDate, String description, String targetAccountNumber, AccountsResponse account) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
        this.targetAccountNumber = targetAccountNumber;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public void setTargetAccountNumber(String targetAccountNumber) {
        this.targetAccountNumber = targetAccountNumber;
    }

    public AccountsResponse getAccount() {
        return account;
    }

    public void setAccount(AccountsResponse account) {
        this.account = account;
    }
}

