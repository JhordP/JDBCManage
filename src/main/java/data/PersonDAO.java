package data;

import java.sql.*;
import java.util.*;

import domain.Login;
import domain.Person;

public class PersonDAO { //DAO: Data Access Object

    private Connection transaccConnection;
    private static final String SQL_SELECT = "SELECT * FROM person;";
    private static final String SQL_INSERT = "INSERT INTO person(person_name, person_lastname, person_email, person_phone) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE person SET person_name = ?, person_lastname = ?, person_email = ?, person_phone = ? WHERE (person_id = ?)";
    private static final String SQL_DELETE = "DELETE FROM person WHERE person_id = ?";

    
    public PersonDAO() {
    }
    
    public PersonDAO(Connection transaccConnection) {
        this.transaccConnection = transaccConnection;
        //PersonUI person = new PersonUI(this.transaccConnection);
    }

    //Menu
    

    public List<Person> select() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Person person = null;
        List<Person> persons = new ArrayList<>();

        try {
            connection = this.transaccConnection != null ? this.transaccConnection : DatabaseConnection.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            result = statement.executeQuery(); // Method .executeQuery(); just works for statement that doesn't modify the DB status
            while (result.next()) {
                //Takes each column to its respective variables so...
                int personID = result.getInt("person_id");
                String personName = result.getString("person_name");
                String personLastname = result.getString("person_lastname");
                String personEmail = result.getString("person_email");
                Long personPhone = result.getLong("person_phone");

                //...so i don't have to use the complete getVar statement  in the constructor creating the person object.
                person = new Person(personID, personName, personLastname, personEmail, personPhone);
                persons.add(person);
            }
        } /*catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        }*/ finally {
            try {
                DatabaseConnection.close(result);
                DatabaseConnection.close(statement);
                if (this.transaccConnection == null) {
                    DatabaseConnection.close(connection);
                }
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return persons;
    }

    public int insert(Person person) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int numRecords = 0;
        
        try {
            con = this.transaccConnection != null ? this.transaccConnection : DatabaseConnection.getConnection();
            statement = con.prepareStatement(SQL_INSERT);

            statement.setString(1, person.getPersonName());
            statement.setString(2, person.getPersonLastname());
            statement.setString(3, person.getPersonEmail());
            statement.setLong(4, person.getPersonPhone());

            numRecords = statement.executeUpdate(); //When the statement/query modifies the DB status, shall use .executeUpdate();
        } /*catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        }*/ finally {
            try {
                DatabaseConnection.close(statement);
                if (this.transaccConnection == null) {
                    DatabaseConnection.close(con);
                }
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return numRecords;   
    }

    public int update(Person person) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int numRecords = 0;

        try {
            con = this.transaccConnection != null ? this.transaccConnection : DatabaseConnection.getConnection();
            statement = con.prepareStatement(SQL_UPDATE);

            statement.setString(1, person.getPersonName());
            statement.setString(2, person.getPersonLastname());
            statement.setString(3, person.getPersonEmail());
            statement.setLong(4, person.getPersonPhone());

            statement.setInt(5, person.getPersonId()); //Parameter Index is NOT the column number. It is the number of "?" sign in the string
            numRecords = statement.executeUpdate();

        } /*catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        }*/ finally {
            try {
                DatabaseConnection.close(statement);
                if (this.transaccConnection == null) {
                    DatabaseConnection.close(con);
                }
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return numRecords;   
    }

    
    public int delete(Person person) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        int numRecords = 0;

        try {
            con = this.transaccConnection != null ? this.transaccConnection : DatabaseConnection.getConnection();
            statement = con.prepareStatement(SQL_DELETE);

            statement.setInt(1, person.getPersonId());
            numRecords = statement.executeUpdate();
        } /*catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        }*/ finally {
            try {
                DatabaseConnection.close(statement);
                if (this.transaccConnection == null) {
                    DatabaseConnection.close(con);
                }
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return numRecords;
    }

    public boolean validate(Login user) {
        LoginDAO loginDAO = new LoginDAO();
        List<Login> users = loginDAO.select();
        boolean valid = false;
        for (Login usr : users) {
            if ((user.getUsername().equals(usr.getUsername())) && (user.getPassw().equals(usr.getPassw()))) 
            {
                valid = true;
            }
        }

        if (valid) {
            return true;
        } else {
            return false;
        }
    }
}
