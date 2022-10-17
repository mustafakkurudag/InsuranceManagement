package com.info.account;

import com.info.InvalidAuthenticationException;
import com.info.address.Address;
import com.info.address.AddressManager;
import com.info.address.BusinessAddress;
import com.info.address.HomeAddress;
import com.info.insurance.Insurance;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account implements Comparable<Account> {
    public enum AuthenticationStatus {
        SUCCESS,
        FAIL
    }
    private User user;
    private ArrayList<Insurance> insurances;
    private AuthenticationStatus authenticationStatus;
    private AddressManager addressManager = new AddressManager();
    private Scanner scan = new Scanner(System.in);
    private String type;

    public Account(User user, String type) {
        this.user = user;
        this.type = type;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
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

        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
        } else if (!(email.equals(user.getEmail())) || !(password.equals(user.getPassword()))) {
            throw new InvalidAuthenticationException("Giriş Hatası!");
        } else {
            this.authenticationStatus = AuthenticationStatus.FAIL;
        }
    }

    public final void showUserInfo(User user){
        //TODO Account typeı (Bireysel, Kurumsal)na göre bilgileri farklı getir.
        System.out.println("Sigortalı bilgileri:");
        System.out.println("İsim: " + user.getName() + " " + user.getSurname());
        System.out.println("Yaş: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Meslek: " + user.getProfession());
        if (user.getAddresses() == null) {
            System.out.println("Kayıtlı ev veya iş adresiniz yok!");
            System.out.println("Adres ekle? A / Çıkış Yap C");
            String answer = scan.nextLine();
            if (answer.toUpperCase().equals("A")) {
                addAddress(user);
                showUserInfo(user);
            } else if(answer.toUpperCase().equals("C")) {
                System.out.println("Adres eklenmeyecek!");
            }
        } else {
            System.out.println("Ev Adresi: " + user.getAddresses().get(0).getAddress());
            System.out.println("İş Adresi: " + user.getAddresses().get(1).getAddress());
            System.out.println("Adres silmek ister misiniz? E / H");
            String answer = scan.nextLine();
            if (answer.toUpperCase().equals("E")) {
                removeAddress();
                showUserInfo(user);
            }
        }

    }

    //bu ve alttaki removeAddress metotlarından kullanıcı adres ekleyip çıkarabilecek.
    public void addAddress(User user) {
        ArrayList<Address> userAddresses = new ArrayList<>();
        System.out.print("Ev adresi:(Boş bırakmak için enter'a basın) ");
        HomeAddress hAddress = new HomeAddress(scan.nextLine());
        System.out.print("İş adresi: (Boş bırakmak için enter'a basın)");
        BusinessAddress bAddress = new BusinessAddress(scan.nextLine());
        userAddresses.add(hAddress);
        userAddresses.add(bAddress);

        addressManager.addAddress(user, userAddresses);
    }

    public void removeAddress() {
        /**
         * kullanıcının adreslerinden çıkartma
         * yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Ev adresi Sil");
        System.out.println("2- İş adresi Sil");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                addressManager.removeAddress(user, 0);
                break;
            case 2:
                addressManager.removeAddress(user, 1);
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }

    }

    public boolean loggedIn() {
        /**
         * kullanıcının login olma durumunu veren değer döndüren
         * fonksiyon tanımlanacaktır.
         */
        return false;
    }

    abstract void addInsurance();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatus authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
