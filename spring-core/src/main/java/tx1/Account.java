package tx1;

//create table account(accountid integer primary key, balance number(10,2));
//insert into account values(69,30000);
//insert into account values(84,30000);
public class Account {
    private double balance;
    private long accountId;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
