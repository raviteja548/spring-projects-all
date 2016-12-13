package namedjdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonClient {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("namedjdbc.xml");
        PersonDAO dao = (PersonDAO) ac.getBean("personDAO");
        dao.getAllPersons();
    }
}
