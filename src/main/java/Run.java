import java.util.Scanner;

import test.*;

/*
 * DATA BASE DATA FOR MAKING IT WORK:
 * DB type -> MySQL
 * DB name -> test
 * 
 * THE MYSQL SCRIPTS ARE IN A FILE CALLED DML.sql on the /src directory
 * 
 * IMPORTANT:
 * For being able to login, you must insert a login user in the DML.sql using the INSERT script of the Line 40
*/
public class Run {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int select;

        System.out.println("Data Base to admin:");
        System.out.println("1) Person");
        System.out.println("2) Login users");
        select = in.nextInt();
        switch (select) {
            case 1: TestPersonDrive.main();
                break;
            case 2: TestUserDrive.main();
                break;
            default: System.out.println("Invalid option number. Try again.");
                break;
        }
        in.close();
    }
}
