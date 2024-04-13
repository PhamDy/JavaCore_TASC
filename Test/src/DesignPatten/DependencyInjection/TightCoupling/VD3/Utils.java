package DesignPatten.DependencyInjection.TightCoupling.VD3;

import java.io.InputStream;
import java.util.Properties;

public class Utils {
    public static AbstractDAO getDAO() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = Utils.class.getResourceAsStream("config.properties");
            // load a properties file
            prop.load(input);
            // get the database value
            String database = prop.getProperty("database");
            if (database.equals("1")) {
                return new MySqlDao();
            }
            if (database.equals("2")) {
                return new MongoDao();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }
}
