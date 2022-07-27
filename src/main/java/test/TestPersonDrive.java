package test;
import java.util.*;

import data.LoginDAO;
import data.PersonDAO;
import domain.Login;
import domain.Person;

public class TestPersonDrive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        PersonDAO personDAO = new PersonDAO();
        LoginDAO loginDAO = new LoginDAO();
        Login usr = new Login();
        int option = 0;
        boolean isValid = false;

        System.out.print("Enter username: ");
        usr.setUsername(input.next());
        System.out.print("Enter password: ");
        usr.setPassw(input.next());

        isValid = loginDAO.validate(usr);
        if (isValid){
            do {
                System.out.println("Access Granted.");
                System.out.println("Type the operation number");
                StringBuilder showMenu = new StringBuilder();
                showMenu.append("1) Show currently data [SELECT]\n")
                        .append("2) Add data [INSERT]\n")
                        .append("3) Modify existing data [UPDATE]\n")
                        .append("4) Dischard data [DELETE]\n");
                System.out.println(showMenu.toString());
    
                option = Integer.parseInt(input.next()); //Takes the input
                persons = personDAO.menu(option); //Uses the menu operations
            } while (option < 1 || option > 4);
            input.close();
    
            System.out.println("Loading data:---");
            persons.forEach(user -> {System.out.println(user);});
    
        } else {
            System.out.println("Too much login attempts. The program will shut down...");
        }

        
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
}
