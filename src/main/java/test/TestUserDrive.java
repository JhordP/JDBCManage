package test;

import java.util.List;

import data.LoginDAO;
import domain.Login;

public class TestUserDrive {
    public static void main(String[] args) {
        LoginDAO login = new LoginDAO();

        Login usr = new Login(4);
        login.delete(usr);
        List<Login> userList = login.select();
        for (Login user : userList) {
            System.out.println(user);
        }
    }
}
