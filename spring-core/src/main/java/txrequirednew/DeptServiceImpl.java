package txrequirednew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean createDept() {
		try{
		deptDao.insertDepartment();
		}catch(Exception e){
			System.out.println(e.getStackTrace().toString());
		}
		return true;
	}

}
