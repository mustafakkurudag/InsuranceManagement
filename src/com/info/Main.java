package com.info;

import com.info.account.Account;
import com.info.account.AccountManager;
import com.info.insurance.*;

import java.util.Scanner;

public class Main {
    private static Account account;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hoşgeldiniz...");
        System.out.print("Email adresiniz: ");
        String email = scanner.nextLine();
        System.out.format("Şifreniz: ");
        String password = scanner.nextLine();

        AccountManager manager = new AccountManager();
        account = manager.login(email, password);
        accountMenu(account);
    }

    private static void accountMenu(Account account) {
        while (account.loggedIn() == Account.AuthenticationStatus.SUCCESS) {
            System.out.println("Sigorta ekle: S / Bilgileri görüntüle B");
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals("S")) {
                account.addInsurance(chooseInsurance());
            } else if(answer.equals("B")) {
                account.showUserInfo(account.getUser());
            } else {
                System.out.println("Geçersiz yanıt!");
            }
        }
    }

    private static Insurance chooseInsurance() {
        System.out.println("1- Araç sigortası ekle");
        System.out.println("2- Konut sigortası ekle");
        System.out.println("3- Sağlık sigortası ekle");
        System.out.println("4- Seyahat sigortası ekle");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new CarInsurance();
            case 2:
                return new ResidenceInsurance();
            case 3:
                return new HealthInsurance();
            case 4:
                return new TravelInsurance();
            default:
                System.out.println("Geçersiz cevap!");
        }
        return null;
    }
}
