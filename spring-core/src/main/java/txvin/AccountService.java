package txvin;

public interface AccountService {
    void transfer(double amount, int fromAccount, int toAccount) throws UserException, InterruptedException;
}
