package jdbctemp;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SelectClient {
	public static void main(String args[]) throws Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"jdbctemp.xml");

		SelectImple s = (SelectImple) ctx.getBean("sel");
		System.out.println("=========================================================================");
		System.out.println("Employee count with Clerk disgnation is: "
				+ s.getEmpCount("CLERK"));
		System.out.println("=========================================================================");
		Map m = s.getEmpDetails(7934);

		System.out.println("Details of empno: 7934 are: " + m.toString());
		System.out.println("=========================================================================");
		System.out.println("Clerk designation employees details are: ");

		List l = s.getEmpDetails("CLERK");

		for (int i = 0; i < l.size(); i++) {
			Map m1 = (Map) l.get(i);

			System.out.println(m1.toString());
		}
		System.out.println("=========================================================================");
		boolean bool = s.registerEmp(1, "Kanakadhar", "MANAGER", 50000);

		System.out.println("Employee registered " + bool);
		System.out.println("=========================================================================");
		bool = s.modifyDesignation(1, "PRESIDENT");

		System.out.println("Employee designation updated " + bool);
		System.out.println("=========================================================================");
		Thread.sleep(3000);

		bool = s.fireEmp(1);

		System.out.println("Employee fired " + bool);
		System.out.println("=========================================================================");
	}
}
