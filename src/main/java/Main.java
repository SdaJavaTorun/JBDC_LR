import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Łukasz on 24.04.2017.
 */
public class Main {

    public static final String JBDC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL

            = "jdbc:mysql://localhost/ksiegarnia?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JBDC_DRIVER);
            System.out.println("Lącze z bazą!!!");

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from books");

            while(resultSet.next()){
                System.out.println(resultSet.getString("title") +  resultSet.getString("author")
                        +  resultSet.getString("published")
                        +  resultSet.getString("isbn")
                        +  resultSet.getString("category")
                        +  resultSet.getString("page_count")
                        +  resultSet.getString("publisher")
                        +  resultSet.getString("price")
                );


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
