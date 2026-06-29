package api.payloads;

public class DepositRequestPayload {
    public long accountId;
    public long amount;

    public DepositRequestPayload() {
    }

    public DepositRequestPayload(long accountId, long amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
