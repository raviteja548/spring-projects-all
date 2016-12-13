package javatpoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.RowMapper;

public class SimpleTest {
  public static void main(String[] args) {
	
	Resource r=new ClassPathResource("javatpoint.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	
	EmpDao dao=(EmpDao)factory.getBean("edao");
	//dao.save(new Emp(23,"sonoo",50000));
	
	//dao.update(new Emp(23,"ojo",1));
	Emp e = new Emp();
	e.setId(23);
	dao.fetch(e);
	
	
  }
}
