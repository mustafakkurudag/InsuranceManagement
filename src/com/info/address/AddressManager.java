package com.info.address;

import com.info.account.User;

import java.util.Scanner;

public class AddressManager {
    //müşteri adreslerinin eklenip çıkarılacağı yer
    //User nesnesinin adres listesine eleman ekleme metodu
    //User nesnesinin adres listesinden eleman çıkarma metodu

    public void addAddress(User user, Address address) {
        user.getAddresses().add(address);
    }

    public void removeAddress(User user, Address address) {
        user.getAddresses().remove(address);
    }
}
