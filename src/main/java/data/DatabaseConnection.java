package data;
import java.sql.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

//Connection Class
public class DatabaseConnection {
    //Connection String
    private static final String JDBC_URL = 
    "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    //Connection User                               //Connection Password
    private static final String JDBC_USER = "root"; private static final String JDBC_PW = "admin";    

    //Connection Pool
    public static DataSource getDataSource() {
        var dataSource = new BasicDataSource();
        //Set the DB Connection info
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PW);

        dataSource.setInitialSize(3); //Gets ready 3 db connections as soon as the app starts.
        return dataSource;
    }

    //Uses DataSource´s getConnection.
    public static Connection getConnection() throws SQLException { 
        return getDataSource().getConnection(); 
    }

    //Closes all the given connections
    public static void closeConnections(Connection dbconnection, Statement declaration, ResultSet queryResult) throws SQLException{ //Uses Statement
        queryResult.close();
        declaration.close();
        dbconnection.close();
    }
    public static void closeConnections(Connection dbconnection, PreparedStatement declaration, ResultSet queryResult) throws SQLException{ //Uses PreparedStatement
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
