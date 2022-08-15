package data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import data.DatabaseConnection;
import domain.Person;

public class PersonUI {
    private Connection connection;
    private PersonDAO dataAccess;
    public PersonUI() throws SQLException {
        //this.connection = connection;
        this.connection = DatabaseConnection.getConnection();
        try {
            if (connection.getAutoCommit() == true) {
                connection.setAutoCommit(false);
            }
            this.dataAccess = new PersonDAO(this.connection);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public List<Person> menu(int option) {
        // PersonDAO dataAccess = new PersonDAO();
        var input = new Scanner(System.in);
        //PersonUI commit = new PersonUI(this.connection);
        List<Person> personList = new ArrayList<>();
        Person person = null;

        int id;
        String name, lastName, email;
        Long phone;

        try {
            switch (option) {
                case 1:
                    personList = dataAccess.select();
                    break;
                case 2:
                    System.out.print("Name: "); name = input.next();
                    System.out.print("Last Name: "); lastName = input.next();
                    System.out.print("E-Mail: "); email = input.next();
                    System.out.print("Phone: "); phone = Long.parseLong(input.next());
                    person = new Person(name, lastName, email, phone);
                    dataAccess.insert(person);
                    personList = dataAccess.select();
                    break;
                case 3:
                    System.out.print("Name: "); name = input.next();
                    System.out.print("Last Name: "); lastName = input.next();
                    System.out.print("E-Mail: "); email = input.next();
                    System.out.print("Phone: "); phone = input.nextLong();
                    System.out.print("ID number to put the data: "); id = Integer.parseInt(input.next());
                    person = new Person(id, name, lastName, email, phone);
                    dataAccess.update(person);
                    personList = dataAccess.select();
                    break;
                case 4:
                    System.out.print("ID number: "); id = input.nextInt();
                    person = new Person(id);
                    dataAccess.delete(person);
                    personList = dataAccess.select();
                    break;
                case 5:
                    save();
                    personList = dataAccess.select();
                    break;
                default:
                    System.out.println("Invalid option number. Try again.");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            discard();
            System.exit(0);
        }
        //input.close();
        return personList;
    }

    public void save() {
        try {
            System.out.println("Save completed successfully.");
            this.connection.commit();
        } catch (SQLException e) {

            try {
                System.out.println("Rollback done. Data was not saved in the Data Base.");
                this.connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace(System.out);
            }
            e.printStackTrace(System.out);
        }
    }

    public void discard(){
        try {
            System.out.println("Rollback done. Data was not saved in the Data Base.");
            this.connection.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace(System.out);
        }
    }
}
