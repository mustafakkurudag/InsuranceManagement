package com.info;

import com.info.account.Account;
import com.info.account.AccountManager;

import java.util.Scanner;

public class Main {
    private static Account account;
    public static void main(String[] args) {
        System.out.println("Hoşgeldiniz...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email adresiniz: ");
        String email = scanner.nextLine();
        System.out.format("Şifreniz: ");
        String password = scanner.nextLine();

        //TODO alttaki metodu çalıştır hata veren yerden devam et
        AccountManager manager = new AccountManager();
        account = manager.login(email, password);
        accountMenu(account);
    }

    private static void accountMenu(Account account) {
        int count = 0;
        while (account.getAuthenticationStatus() == Account.AuthenticationStatus.SUCCESS) {
            System.out.println((++count) + ". Gösterim");
            account.showUserInfo(account.getUser());
        }
    }
}
