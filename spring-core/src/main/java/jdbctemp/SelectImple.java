package jdbctemp;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;


//Note: Add DAO libraries to build path

public class SelectImple implements SelectInter{

		JdbcTemplate jt;
		
		String qry;

		public void setJt(JdbcTemplate jt) {
			this.jt = jt;
		}

		public boolean fireEmp(int eno) {
			// TODO Auto-generated method stub
			qry = "delete from emp where empno = ?";
			int res = jt.update(qry, new Object[]{new Integer(eno)});
			
			
			if(res == 0)
				return false;
			else
				return true;
		}

		public int getEmpCount(String desg) {
			// TODO Auto-generated method stub
			
			
			qry = "select count(*) from emp where job = ?"; 
				
			int count = jt.queryForInt(qry, new String[]{desg});
			
			
			return count;
		}

		public Map getEmpDetails(int eno) {
			// TODO Auto-generated method stub
			qry = "select * from emp where empno = ? ";
			Map<String ,Object> m = jt.queryForMap(qry, new Object[]{new Integer(eno)});
			for(Map.Entry<String,Object> map: m.entrySet()){
				System.out.println("/////////");
				System.out.println(map.getKey()+" "+map.getValue());
				System.out.println("/////////");
			}
			
			
			Iterator itr = m.keySet().iterator();
			System.out.println("Map keys are............................................");
			while(itr.hasNext()){
				Object obj = itr.next();
				System.out.println("KEY IS "+obj+" VALUE "+m.get(obj));
			}
			System.out.println("-----------------------------------------------------");
			
			
			
			return m;
		}

		public List getEmpDetails(String desg) {
			// TODO Auto-generated method stub
			

			qry = "select * from emp where job = ?";
			List l = jt.queryForList(qry, new Object[]{desg});
			
			return l;
		}

		public boolean modifyDesignation(int no, String newDesig) {
			// TODO Auto-generated method stub
			qry = "update emp set job = ? where empno = ?";
			int res = jt.update(qry, new Object[]{newDesig, new Integer(no)});
			
			if(res == 0)
				return false;
			else
				return true;
		}

		public boolean registerEmp(int no, String name, String desg, int sal) {
			// TODO Auto-generated method stub
			qry = "insert into emp  (empno, ename, job, sal) values(?, ?, ?, ?)";
			
			
			int res = jt.update(qry, new Object[]{new Integer(no), name, desg, new Integer(sal)});
			
			if(res == 0)
				return false;
			else
				return true;
		}
		
		
}
