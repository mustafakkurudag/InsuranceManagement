package com.info.address;

import com.info.account.User;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressManager {
    //müşteri adreslerinin eklenip çıkarılacağı yer
    //User nesnesinin adres listesine eleman ekleme metodu
    //User nesnesinin adres listesinden eleman çıkarma metodu

    public void addAddress(User user, ArrayList<Address> addresses) {
        user.setAddresses(addresses);
    }

    public void removeAddress(User user, int id) {
        Address a = new Address() {
            @Override
            public String getAddress() {
                return null;
            }

            @Override
            public void setAddress(String address) {
                address = "-";
            }
        };

        user.getAddresses().set(id, a);
    }
}
