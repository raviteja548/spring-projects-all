package tx1;

import org.springframework.transaction.annotation.Transactional;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;    

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(rollbackFor = UserException.class)
    public void transfer(double amount, int fromAccount, int toAccount) throws UserException, InterruptedException {
        accountDao.transfer(amount, fromAccount, toAccount);
    }
    
}
