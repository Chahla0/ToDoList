package DB_new;

import java.sql.Connection;
import java.sql.SQLOutput;

public class App {
    public static void main(String[] args) {
        Connection conn = DataBseCon.getConnection();
        if(conn==null)
        {
            System.out.println("faild");
        }else {
            System.out.println("success");
        }
    }
}
