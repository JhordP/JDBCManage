package data;
import java.sql.*;

//Connection Class
public class DatabaseConnection {
    //Connection String
    private static final String JDBC_URL = 
    "jdbc:mysql://localhost:3306/db?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    //Connection User                               //Connection Password
    private static final String JDBC_USER = "root"; private static final String JDBC_PW = "admin";    

    //Uses Driver Manager to get the database connection using user and password
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PW);
    }

    //Closes all the given connections
    public void closeConnections(Connection dbconnection, Statement declaration, ResultSet queryResult) throws SQLException{
        queryResult.close();
        declaration.close();
        dbconnection.close();
    }

    //Closes the objects one by one
    public static void close(ResultSet rs) throws SQLException {rs.close();}
    public static void close(Statement stm) throws SQLException {stm.close();}
    public static void close(PreparedStatement pstm) throws SQLException {pstm.close();}
    public static void close(Connection con) throws SQLException {con.close();}
}
