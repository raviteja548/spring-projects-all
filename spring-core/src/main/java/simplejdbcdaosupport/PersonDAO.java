package simplejdbcdaosupport;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class PersonDAO  extends SimpleJdbcDaoSupport{


  



	public void getAllPersons() {
        String sql = "select count(*) from person where sal > ?";
     
        int i = getSimpleJdbcTemplate().queryForInt(sql, 9000);
        System.out.println(i);

    }

 
}
