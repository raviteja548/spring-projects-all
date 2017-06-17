package txrequirednew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	private String empInsert = "INSERT INTO emp VALUES ('1000','Ravi','CLERK','7782','1990-01-01','1235.00',NULL,'50');";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertEmployee() {

		int n = jdbcTemplate.update(empInsert);
		System.out.println(n + "emp insertion status");
		return false;
	}

}
