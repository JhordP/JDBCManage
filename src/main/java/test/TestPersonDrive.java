package test;

import java.util.List;

import data.PersonDAO;
import domain.Person;

public class TestPersonDrive {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        List<Person> personList = personDAO.select();
        for (Person person : personList) {
            System.out.println(person);
        }

    }
}
