package namedjdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class PersonDAO extends NamedParameterJdbcDaoSupport{

  /*  public PersonDAO(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}
*/
	//private SimpleJdbcTemplate sjt;

  

    public void getAllPersons() {
        String sql = "select count(*) from person where sal > :sal";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("sal",9000);
        int i = getNamedParameterJdbcTemplate().queryForInt(sql, parameters);
        System.out.println(i);

    }

   /* public void setSjt(SimpleJdbcTemplate sjt) {
        this.sjt = sjt;
    }*/
}
