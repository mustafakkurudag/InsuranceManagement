package com.info.address;

import com.info.account.User;

public class AddressManager {
    //müşteri adreslerinin eklenip çıkarılacağı yer
    //User nesnesinin adres listesine eleman ekleme metodu
    //User nesnesinin adres listesinden eleman çıkarma metodu

    public static void addAddress(User user, Address address) {
        user.getAddresses().add(address);
    }

    public static void removeAddress(User user, Address address) {
        user.getAddresses().remove(address);
    }
}
