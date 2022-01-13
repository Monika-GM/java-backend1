package menu;

import db.Connectivity;
import service.DbService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private final DbService service;
    public Menu() throws SQLException {

        var connectivity = new Connectivity();
        service = new DbService(connectivity.getConnection());
    }

    private String prepareMenu() {
        String title = "\n --- Banking System ---";
        String m1 = "\n 1. Create New Account";
        String m2 = "\n 2. Show All Accounts";
        String m3 = "\n 3. Display Balance";
        String m4 = "\n 4. Transfer Money";
        String m5 = "\n 5. Withdraw";
        String m6 = "\n 6. Deposit";
        String m7 = "\n 7. Activate Account";
        String m8 = "\n 8. DeActivate Account";
        String m9 = "\n 9. Exit";




        return title + m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8 + m9;
    }

    public void showMenu() throws SQLException {
        var scanner = new Scanner(System.in);
        while(true) {
            System.out.println(prepareMenu());
            int ch = scanner.nextInt();
            if(ch == 9) System.exit(1);
            if(ch == 3){
                System.out.println("Enter your Account Number");
                int num = scanner.nextInt();
                service.findByAccountNum(num);
            }
            if(ch == 2){
                service.showAllAccounts();
            }

            if(ch == 9) System.exit(1);
            if(ch == 1) {
                System.out.println("Enter Account Number : ");
                int acNum = scanner.nextInt();

                System.out.println("Enter Balance : ");
                double amt = scanner.nextDouble();

                System.out.println("Enter Name : ");
                String name = scanner.nextLine();

                try {
                    service.createNewAccount(
                            acNum,
                            amt,
                            name,
                            Date.valueOf(LocalDate.now()),
                            false
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

