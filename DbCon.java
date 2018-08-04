
package handwriting_recognition_system;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbCon {
    
    private static java.sql.Connection firstconn ;

    private static void setconn() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            setLocalconn(DriverManager.getConnection("jdbc:mysql://localhost:3306/OCR", "root", "1111"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setLocalconn(java.sql.Connection conn) {
        firstconn = conn;
    }

    public Connection getConnection() {
        try {
            if (firstconn.isClosed()) {
                setconn();
            } else if (firstconn == null) {
                setconn();
            }
            return firstconn;
        } catch (Exception e) {
            setconn();
            return firstconn;
        }
    }
    
}
