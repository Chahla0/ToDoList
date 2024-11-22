package DB_new;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class DataBseCon {
    private static final String HOST="127.0.0.1";
    private static final int PORT=3306;
    private static final String DB_NAME="Tasks";
    private static final String USER="root";
    private static final String PASSWORD="";

    public static Connection connection;
    public  static Connection getConnection(){
        jdbc:mysql://localhost:3306/dataBseCon
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DB_NAME), USER, PASSWORD);
        }catch (SQLException se)
        {
            se.printStackTrace();
        }
        return connection;
    }
}
