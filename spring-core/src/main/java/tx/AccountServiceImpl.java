package tx;


public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;    

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(double amount, int fromAccount, int toAccount) {
        accountDao.transfer(amount, fromAccount, toAccount);
    }
    
}
