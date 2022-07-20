package test;

import java.util.*;

import data.PersonDAO;
import domain.Person;

public class TestPersonDrive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PersonDAO personDAO = new PersonDAO();
        List<Person> personList = personDAO.select();
        for (Person person : personList) {
            System.out.println(person);
        }
        // System.out.print("Name: "); String name = input.next();
        // System.out.print("Last Name: "); String lastName = input.next();
        // System.out.print("E-Mail: "); String email = input.next();
        // System.out.print("Phone: "); Long phone = input.nextLong();
        input.close();

        System.out.println("After Updating:---");
        //Inserting
        // var person = new Person(name, lastName, email, phone);
        // personDAO.insert(person);

        // personList = personDAO.select();
        // personList.forEach(p -> {System.out.println(p);});

        //Updating
        var person = new Person(5, "Jhederly", "Polanco", "jhederlypolanco@gmail.com", 8493992117L);
        personDAO.update(person);

        personList = personDAO.select();
        personList.forEach(p -> {System.out.println(p);});
    }
}
