package propertyplaceholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 14/1/16
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TestBean1 {

    @Autowired
    private DBConfig   dbConfig;




    public DBConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
}
