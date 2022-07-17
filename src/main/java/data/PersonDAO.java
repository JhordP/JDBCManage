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

        return persons;
    }
}
