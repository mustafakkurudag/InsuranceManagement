package com.info.account;

import com.info.User;
import com.info.insurance.Insurance;

import java.util.ArrayList;

public abstract class Account {
    private enum AuthenticationStatus {
        SUCCESS,
        FAIL
    }
    private User user;
    private ArrayList<Insurance> insurances;

    public void login(String email, String password){
        /**
         * kullanıcının hesabına login olabilmesi için bir fonksiyon tanımlanacaktır.
         * Bu fonksiyon email ve şifre bilgisi alacak ve gelen email şifre bilgisini
         * User sınıfındaki email ve şifre ile kıyaslayacaktır. Eğer girilen bilgiler
         * doğruysa giriş işlemi başarılı olacaktır. Ve kullanıcının login olma durumu
         * SUCCESS'e çekilecektir. Giriş işlemi başarısız ise
         * "InvalidAuthenticationException" tipinde bir hata fırlatacaktır.
         * Bu hata sınıfını Exception isimli Java sınıfından kalıtım alarak sizin
         * yazmanız gerekecektir.
         */
    }

    public final void showUserInfo(User user){}

    public void addAddress() {
        /**
         * kullanıcının adreslerine ekleme yapabileceği bir soyut olmayan
         * fonksiyon tanımlanacaktır.
         * kullanıcının login olma durumunu veren değer döndüren
         * fonksiyon tanımlanacaktır.
         */
    }

    public void removeAddress() {
        /**
         * kullanıcının adreslerinden çıkartma
         * yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır.
         */
    }

    public boolean loggedIn() {
        /**
         * kullanıcının login olma durumunu veren değer döndüren
         * fonksiyon tanımlanacaktır.
         */
        return false;
    }

    abstract void addInsurance();
}
