package txrequirednew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DeptService deptService;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean createEmployee() {
		employeeDao.insertEmployee();
		deptService.createDept();
		return true;
	}

}
