package txonh2;

public interface AccountDao  {
    
    void transfer(double amount, int fromAccount, int toAccount) throws UserException, InterruptedException;
}
