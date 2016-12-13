package tx1;

public interface AccountService {
    void transfer(double amount, int fromAccount, int toAccount) throws UserException, InterruptedException;
}
