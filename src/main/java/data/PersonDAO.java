package data;

import java.sql.*;
import java.util.*;
import domain.Person;

public class PersonDAO { //DAO: Data Access Object
    private static final String SQL_SELECT = "SELECT * FROM person;";
    private static final String SQL_INSERT = "INSERT INTO person(person_name, person_lastname, person_email, person_phone) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE person SET person_name = ?, person_lastname = ?, person_email = ?, person_phone = ? WHERE (person_id = ?)";
    private static final String SQL_DELETE = "DELETE FROM person WHERE person_id = ?";

    //Menu
    public List<Person> menu(int option) {
        var input = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        Person person = null;

        int id;
        String name, lastName, email;
        Long phone;

        switch (option) {
            case 1:
                personList = select();
                break;
            case 2:
                System.out.print("Name: "); name = input.next();
                System.out.print("Last Name: "); lastName = input.next();
                System.out.print("E-Mail: "); email = input.next();
                System.out.print("Phone: "); phone = Long.parseLong(input.next());
                person = new Person(name, lastName, email, phone);
                insert(person);
                personList = select();
                break;
            case 3:
                System.out.print("Name: "); name = input.next();
                System.out.print("Last Name: "); lastName = input.next();
                System.out.print("E-Mail: "); email = input.next();
                System.out.print("Phone: "); phone = input.nextLong();
                System.out.print("ID number to put the data: "); id = Integer.parseInt(input.next());
                person = new Person(id, name, lastName, email, phone);
                update(person);
                personList = select();
                break;
            case 4:
                System.out.print("ID number: "); id = input.nextInt();
                person = new Person(id);
                delete(person);
                personList = select();
                break;
            default:
                System.out.println("Invalid option number. Try again.");
                break;
        }
        input.close();
        return personList;
    }

    public List<Person> select() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Person person = null;
        List<Person> persons = new ArrayList<>();

        try {
            connection = DatabaseConnection.getConnection();
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
        } catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            try {
                DatabaseConnection.closeConnections(connection, statement, result);
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return persons;
    }

    public int insert(Person person) {
        Connection con = null;
        PreparedStatement statement = null;
        int numRecords = 0;
        
        try {
            con = DatabaseConnection.getConnection();
            statement = con.prepareStatement(SQL_INSERT);

            statement.setString(1, person.getPersonName());
            statement.setString(2, person.getPersonLastname());
            statement.setString(3, person.getPersonEmail());
            statement.setLong(4, person.getPersonPhone());

            numRecords = statement.executeUpdate(); //When the statement/query modifies the DB status, shall use .executeUpdate();
        } catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            try {
                DatabaseConnection.close(statement);
                DatabaseConnection.close(con);
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return numRecords;   
    }

    public int update(Person person) {
        Connection con = null;
        PreparedStatement statement = null;
        int numRecords = 0;

        try {
            con = DatabaseConnection.getConnection();
            statement = con.prepareStatement(SQL_UPDATE);

            statement.setString(1, person.getPersonName());
            statement.setString(2, person.getPersonLastname());
            statement.setString(3, person.getPersonEmail());
            statement.setLong(4, person.getPersonPhone());

            statement.setInt(5, person.getPersonId()); //Parameter Index is NOT the column number. It is the number of "?" sign in the string
            numRecords = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            try {
                DatabaseConnection.close(statement);
                DatabaseConnection.close(con);
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return numRecords;   
    }

    
    public int delete(Person person) {
        Connection con = null;
        PreparedStatement statement = null;
        int numRecords = 0;

        try {
            con = DatabaseConnection.getConnection();
            statement = con.prepareStatement(SQL_DELETE);

            statement.setInt(1, person.getPersonId());
            numRecords = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An error has ocurred trying to reach the Data Base. "+e.getMessage());
            e.printStackTrace(System.out);
        } finally {
            try {
                DatabaseConnection.close(statement);
                DatabaseConnection.close(con);
            } catch (SQLException e) {
                System.out.println("An error has ocurred trying to close the Data Base connection. "+e.getMessage());
                e.printStackTrace(System.out);
            }
        }
        return numRecords;
    }
}
