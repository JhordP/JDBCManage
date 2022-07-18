package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.Person;

public class PersonDAO { //DAO: Data Access Object
    private static final String SQL_SELECT = "SELECT * FROM persona;";

    public List<Person> select() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Person person = null;
        List<Person> persons = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            result = statement.executeQuery(SQL_SELECT);
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
        } catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            try {
                DatabaseConnection.closeConnections(connection, statement, result);
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace();
            }
        }
        return persons;
    }
}
