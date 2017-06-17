package txrequirednew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeptDaoImpl implements DeptDao {

	private String deptInsert = "INSERT INTO dept VALUES ('500','MATERIAL','ALASKA');";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertDepartment(){
		jdbcTemplate.update(deptInsert);
		return false;
	}

}
