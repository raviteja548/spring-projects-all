package simplejdbctemplate;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class PersonDAO {

	SimpleJdbcTemplate sjt;
	
	

	public SimpleJdbcTemplate getSjt() {
		return sjt;
	}


	public void setSjt(SimpleJdbcTemplate sjt) {
		this.sjt = sjt;
	}


	public void setDataSource(DataSource ds){
		this.sjt = new SimpleJdbcTemplate(ds);
	}
	

	public void getAllPersons() {
		
		
		  String sql = "select count(*) from person where sal > ?";
		
		  int i = sjt.queryForInt(sql, 9000);
		 System.out.println(i);
		 
	}

}
