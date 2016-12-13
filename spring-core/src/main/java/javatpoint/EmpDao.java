package javatpoint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.util.*;

public class EmpDao {
NamedParameterJdbcTemplate template;

public NamedParameterJdbcTemplate getTemplate() {
	return template;
}


public void setTemplate(NamedParameterJdbcTemplate template) {
	this.template = template;
}

/*
public EmpDao(NamedParameterJdbcTemplate template) {
		this.template = template;
}*/


public  void save (Emp e){
String query="insert into employee values (:id,:name,:salary)";

Map<String,Object> map=new HashMap<String,Object>();
map.put("id",e.getId());
map.put("name",e.getName());
map.put("salary",e.getSalary());

template.update(query, map);
}

public  void update (Emp e){
String query="update employee set name = :name where id = :id";

Map<String,Object> map=new HashMap<String,Object>();
map.put("id",e.getId());
map.put("name",e.getName());
//map.put("salary",e.getSalary());

template.update(query, map);

}

public void fetch(Emp e){
	String query = "select * from employee where ID =:id";
	Map<String,Integer> map=new HashMap<String,Integer>();
	map.put("id",e.getId());
	List<Emp> al = new ArrayList<Emp>();
	// Emp ee =(Emp) template.queryForObject(query, map, new EmpRowMapper());
	Object o = template.queryForObject(query, map,new EmpRowMapper());
	Emp ee = (Emp)o;
	/*System.out.println(al.size()+""+al.getClass());
	Emp emp = (Emp)al.get(0);*/
	System.out.println(ee.getName() + "" +ee.getSalary());




}


}



class EmpRowMapper implements RowMapper{
List<Emp> al = new ArrayList<Emp>();
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		Emp e = new Emp();
		e.setId(arg0.getInt("id"));
		e.setName(arg0.getString("name"));
		e.setSalary(arg0.getInt("salary"));
		al.add(e);
		return e;
	}
	
}
