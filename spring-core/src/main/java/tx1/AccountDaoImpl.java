package tx1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {


    public final String deposite = "update account69 set balance = balance + ? where accountid = ?";

    public final String withdraw = "update account69 set balance = balance - ? where accountid = ?";

    public final String insert = "insert into account69 (accountid,balance) values(?,?)";

    public static final String select = "select balance from account69 where accountid=?";

    JdbcTemplate jdbcTemplate = null;
    @Transactional
    public void transfer(double amount, int fromAccount, int toAccount) throws UserException, InterruptedException {
        jdbcTemplate = getJdbcTemplate();
        t1(amount, fromAccount);
        
        int temp = getJdbcTemplate().queryForInt(select,102);
        System.out.println(temp+"  value");
        Thread.sleep(3000);
        int n = t2();
        System.out.println(n + "in db");
    }

    public void t1(double amount, int fromAccount) {
        getJdbcTemplate().update(insert, fromAccount, 100);

        int bal = jdbcTemplate.queryForInt(select, fromAccount);
        if(bal - amount < 0) {
            throw new UserException("exception caught");
        }
    }

    public int t2() throws UserException {
        //	getJdbcTemplate().update(insert, 101, 100);
        int n = 0;

        n = getJdbcTemplate().queryForInt("select balance from account69 where accountid=102");

        if (n > 90) {
            throw new UserException("exception caught");
        }

        return n;
    }
}
