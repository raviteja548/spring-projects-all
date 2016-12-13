package jdbcdaosupport;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDAO extends JdbcDaoSupport{

  /*  public PersonDAO(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}
*/
	//private SimpleJdbcTemplate sjt;

  

    public void getAllPersons() {
        String sql = "select count(*) from person where sal > ?";
        int i = getJdbcTemplate().queryForInt(sql, 9000);
        System.out.println(i);

    }

   /* public void setSjt(SimpleJdbcTemplate sjt) {
        this.sjt = sjt;
    }*/
}
