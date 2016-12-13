package tx1;

public interface AccountDao  {
    
    void transfer(double amount, int fromAccount, int toAccount) throws UserException, InterruptedException;
}
