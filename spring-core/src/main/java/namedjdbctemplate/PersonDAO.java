package namedjdbctemplate;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PersonDAO{


  
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	
	
	public void setDataSource(DataSource dataSource) {
	
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}



	public void getAllPersons() {
        String sql = "select count(*) from person where sal > :sal";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("sal",9000);
        int i = namedParameterJdbcTemplate.queryForInt(sql, parameters);
        System.out.println(i);

    }

 
}
