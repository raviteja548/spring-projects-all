package tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");

        //ApplicationContext context2 = new ClassPathXmlApplicationContext(" jdbcdeclarativetxdemo/SpringTxContext2.0.xml ");
        AccountService service = (AccountService) context.getBean("accountService");
        service.transfer(10,108,109);
    }
    
}
