package test;
import java.util.*;

import data.DatabaseConnection;
import data.LoginDAO;
import data.PersonDAO;
import data.PersonUI;
import domain.Login;
import domain.Person;
import java.sql.Connection;
import java.sql.SQLException;

public class TestPersonDrive {
    private static List<Person> persons;
    private static PersonDAO personDAO;

    public static void main() throws SQLException {
        Scanner in = new Scanner(System.in);
        persons = new ArrayList<>();
        Connection transactionConnection = null;
        try {
            transactionConnection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        personDAO = new PersonDAO(transactionConnection);
        LoginDAO loginDAO = new LoginDAO();
        Login usr = new Login();
        boolean isValid = false;

        System.out.print("Enter username: ");
        usr.setUsername(in.next());
        System.out.print("Enter password: ");
        usr.setPassw(in.next());
        //in.close();
        isValid = loginDAO.validate(usr);
        if (isValid){
           showInfo();
    
        } else {
            System.out.println("Too much login attempts. The program will shut down...");
        }

        //Below there is just tests about when learning the connections to the DB.

        //#region
        //Inserting
        // var person = new Person(name, lastName, email, phone);
        // personDAO.insert(person);

        // personList = personDAO.select();
        // personList.forEach(p -> {System.out.println(p);});

        //Updating
        // var person = new Person(5, "Jhederly", "Polanco", "jhederlypolanco@gmail.com", 8493992117L);
        // personDAO.update(person);

        // personList = personDAO.select();
        // personList.forEach(p -> {System.out.println(p);});

        //Delete
        // var person = new Person(6);
        // personDAO.delete(person);
        // personList = personDAO.select();
        // personList.forEach(p -> {System.out.println(p);});
        //#endregion
    }

    private static void showInfo() throws SQLException {
        int option = 0;
        PersonUI p = new PersonUI();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Access Granted.");
            System.out.println("Type the operation number");
            StringBuilder showMenu = new StringBuilder();
            showMenu.append("1) Show currently data [SELECT]\n")
                    .append("2) Add data [INSERT]\n")
                    .append("3) Modify existing data [UPDATE]\n")
                    .append("4) Dischard data [DELETE]\n")
                    .append("5) Save changes");
            System.out.println(showMenu.toString());

            option = Integer.parseInt(input.next()); //Takes the input
            persons = p.menu(option); //Uses the menu operations
        } while (option < 1 || option > 5);
        //input.close();

        System.out.println("Loading data:---");
        persons.forEach(user -> {System.out.println(user);});
        if (option != 5) {
            showInfo();
        }
    }
}
