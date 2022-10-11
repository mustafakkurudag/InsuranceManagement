package com.info;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hoşgeldiniz...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email adresiniz: ");
        String email = scanner.nextLine();
        System.out.format("Şifreniz: ");
        String password = scanner.nextLine();

    }
}
