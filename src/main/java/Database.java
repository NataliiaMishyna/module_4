import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final Database INSTANCE = new Database();
    private static Connection connection;
    private Database(){
        try{
            String url = "jdbc:h2:./myBaseModule4";
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static Database getInstance(){

        return INSTANCE;
    }
    public static Connection getConnection(){
        return connection;
    }
    public void Close() throws SQLException {
        connection.close();
    }
    public int executeUpdate(String sql) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}


