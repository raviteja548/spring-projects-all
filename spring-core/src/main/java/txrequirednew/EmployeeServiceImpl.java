package txrequirednew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean createEmployee() {
		employeeDao.insertEmployee();
		createDept();
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean createDept() {
		employeeDao.insertDepartment();
		return false;
	}

}
