package com.info;

import com.info.account.AccountManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hoşgeldiniz...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email adresiniz: ");
        String email = scanner.nextLine();
        System.out.format("Şifreniz: ");
        String password = scanner.nextLine();

        //TODO alttaki metodu çalıştır hata veren yerden devam et
        AccountManager manager = new AccountManager();
        manager.login(email, password);

    }
}
