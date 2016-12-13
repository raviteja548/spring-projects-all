package tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;


public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
	 
   
    
	
    public final String deposite = "update account69 set balance = balance + ? where accountid = ?";
    public final String withdraw = "update account69 set balance = balance - ? where accountid = ?";
    public final String insert = "insert into account69 (accountid,balance) values(?,?)";
    JdbcTemplate jdbcTemplate = null;
    @Transactional
    public void transfer(double amount, int fromAccount, int toAccount) {
    	jdbcTemplate = getJdbcTemplate();
    	try{ 
    
t1(null,fromAccount,amount);
t1(null,fromAccount,amount);
    	
    	/*getJdbcTemplate().update(withdraw,new Object[]{new Double(amount),new Integer(fromAccount)});
        getJdbcTemplate().update(deposite,new Object[]{new Double(amount),new Integer(toAccount)});
        */
        
        
    }catch(Exception e){
    	e.printStackTrace();
    }
    }   
    
    public void t1(String a,int fromAccount,double balance){
    	System.out.println("---------");
    	jdbcTemplate.update(insert, 100, 100);
    	System.out.println("---------");
    	
    }
    
    public void t2(String a,int fromAccount,double balance){
    	System.out.println("---------");
    	jdbcTemplate.update(insert, 100, 100);
    	System.out.println("---------");
    	
    }
}
