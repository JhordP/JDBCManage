package test;

import java.util.*;

import data.LoginDAO;
import domain.Login;

/*
 * DATA BASE DATA FOR MAKING IT WORK:
 * DB type -> MySQL
 * DB name -> test
 * 
 * THE MYSQL SCRIPTS ARE IN A FILE CALLED DML.sql on the /src directory
 * 
 * MYSQL SCRIPT FOR THE TABLE PERSON:
    CREATE TABLE person(
    person_id INT NOT NULL auto_increment, 
    person_name VARCHAR(10),
    person_lastname VARCHAR(10),
    person_email VARCHAR(25),
    person_phone LONG,
    PRIMARY KEY(person_id)); 
 *
 * MYSQL SCRIPT FOR THE TABLE LOGIN:
    CREATE TABLE login (
    id INT NOT NULL auto_increment,
    username VARCHAR(15),
    passw VARCHAR(50),
    PRIMARY KEY(id)
    );
 */

public class TestUserDrive {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        LoginDAO loginDAO = new LoginDAO();
        Login usr = new Login();
        int option = 0;
        List<Login> users = new ArrayList<>();
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
                users = loginDAO.menu(option); //Uses the menu operations
            } while (option < 1 || option > 4);
            input.close();
    
            System.out.println("Loading data:---");
            users.forEach(user -> {System.out.println(user);});
    
        } else {
            System.out.println("Too much login attempts. The program will shut down...");
        }
    }
        

}
