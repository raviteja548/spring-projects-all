package tx;

public interface AccountDao {
    
    void transfer(double amount, int fromAccount, int toAccount);
}
