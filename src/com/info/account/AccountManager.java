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
        accounts.add(new Enterprise(new User("Ayşe Tuğçe", "Özet", "ato@mail.com", "67890",
                "Türkçe Öğretmeni", 28, new Date())));
    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(TreeSet<Account> accounts) {
        this.accounts = accounts;
    }

    public Account login(String email, String password) {
        try {
            for (Account a : accounts) {
                a.login(email, password);
                if (a.getAuthenticationStatus() == Account.AuthenticationStatus.SUCCESS) {
                    return a;
                } else {
                    continue;
                }
            }
        } catch (InvalidAuthenticationException e) {
            e.printStackTrace();
        }
        /**
         * bu sınıf içinde login isminde bir fonksiyon tanımlayınız.
         * Bu fonksiyon dışarıdan verilen email ve şifre bilgisini alıp Account listesi
         * üzerinde dolaşıp uygun bir giriş işlemi bulursa Account nesnesini
         * çağrıldığı yere dönecektir. Bu fonksiyon Account nesnesi üzerindeki
         * "login" olma fonksiyonunu çağıracaktır. Unutmayın bu fonksiyon
         * "InvalidAuthenticationException" tipinde hata fırlatabiliyordu.
         * Bu nedenle burada try-catch mekanizması kurmayı unutmayınız.
         */
        return null;
    }
}
