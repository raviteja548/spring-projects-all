package tx;

public interface AccountService {
    void transfer(double amount, int fromAccount, int toAccount);
}
