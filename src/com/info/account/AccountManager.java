package com.info.account;

import com.info.InvalidAuthenticationException;

import java.util.*;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return 1;
            }
        });
        accounts.add(new Individual(new User("Mustafa Kemal", "Kurudağ", "mkk@mail.com", "12345",
                "Java Developer", 27, new Date())));
        accounts.add(new Enterprise(new User("Ayşetuuu Türkçe Öğretim Kurumu", "-", "ato@mail.com", "67890",
                "Türkçe Öğretmeni", 28, new Date())));
    }

    public Account login(String email, String password) {
        List<Account> accountList = accounts.stream().toList();
        try {
            if (findIndex(email, password) == 0){
                accountList.get(0).login(email, password);
                if (accountList.get(0).loggedIn() != Account.AuthenticationStatus.SUCCESS) {
                    System.out.println();
                } else {
                    return accountList.get(0);
                }
            } else if (findIndex(email, password) == 1){
                accountList.get(1).login(email, password);
                if (accountList.get(1).loggedIn() != Account.AuthenticationStatus.SUCCESS) {
                    System.out.println();
                } else {
                    return accountList.get(1);
                }
            } else {
                throw new InvalidAuthenticationException("Giriş Hatası!");
            }
        } catch (InvalidAuthenticationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int findIndex(String em, String pas) {
        List<Account> accountList = accounts.stream().toList();
        int index = -1;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUser().getEmail().equals(em) && accountList.get(i).getUser().getPassword().equals(pas)) {
                index = i;
            }
        }
        return index;
    }
}
