package api.models;

public class AccountsResponse {
    long id;
    String accountNumber;
    String accountType;
    String aadharNumber;
    String panNumber;
    Double balance;
    boolean active;
    String createdAt;
    Customer customer;

    public AccountsResponse(){

    }

    public AccountsResponse(long id, String accountNumber, String accountType, String aadharNumber, String panNumber, Double balance, boolean active, String createdAt, Customer customer) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber;
        this.balance = balance;
        this.active = active;
        this.createdAt = createdAt;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
