package com.info.account;

import com.info.InvalidAuthenticationException;

import java.util.Date;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
        accounts.add(new Individual(new User("Mustafa Kemal", "Kurudağ", "mkk@mail.com", "12345",
                "Java Developer", 27, new Date())));
        accounts.add(new Enterprise(new User("Ayşetuuu Türkçe Öğretim Kurumu", "-", "ato@mail.com", "67890",
                "Türkçe Öğretmeni", 28, new Date())));
    }

    public Account login(String email, String password) {
        try {
            for (Account a : accounts) {
                a.login(email, password);
                if (a.loggedIn() != Account.AuthenticationStatus.SUCCESS) {
                    continue;
                } else {
                    return a;
                }
            }
        } catch (InvalidAuthenticationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
