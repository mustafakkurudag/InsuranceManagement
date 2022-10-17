package com.info.account;

import com.info.InvalidAuthenticationException;
import com.info.address.Address;
import com.info.address.AddressManager;
import com.info.address.BusinessAddress;
import com.info.address.HomeAddress;
import com.info.insurance.CarInsurance;
import com.info.insurance.Insurance;
import com.info.insurance.TravelInsurance;

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
        if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
        } else if (!(email.equals(user.getEmail())) || !(password.equals(user.getPassword()))) {
            throw new InvalidAuthenticationException("Giriş Hatası!");
        } else {
            this.authenticationStatus = AuthenticationStatus.FAIL;
        }
    }

    public final void showUserInfo(User user){
        System.out.println("Sigortalı bilgileri:");
        System.out.println("Üyelik Tipi: " + getType());
        System.out.println("İsim: " + user.getName() + " " + user.getSurname());
        System.out.println("Yaş: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Meslek: " + user.getProfession());
        System.out.print("Sigortalar: ");
        if (getInsurances() != null)
            showInsurances(getInsurances());
        else
            System.out.println("-");
        if (user.getAddresses() == null) {
            System.out.println("Kayıtlı ev veya iş adresiniz yok!");
            System.out.println("Adres ekle? A / Çıkış Yap C");
            String answer = scan.nextLine().toUpperCase();
            if (answer.equals("A")) {
                addAddress(user);
                showUserInfo(user);
            } else if(answer.equals("C")) {
                System.out.println("Çıkış yapılıyor...");
                authenticationStatus = AuthenticationStatus.FAIL;
            }
        } else {
            System.out.println("Ev Adresi: " + user.getAddresses().get(0).getAddress());
            System.out.println("İş Adresi: " + user.getAddresses().get(1).getAddress());
            System.out.println("Adres silmek ister misiniz? E / H");
            String answer = scan.nextLine().toUpperCase();
            if (answer.equals("E")) {
                removeAddress();
                showUserInfo(user);
            }
        }

    }

    public void showInsurances(ArrayList<Insurance> insurances) {
        for (Insurance s :
                insurances) {
            System.out.print(s.getInsuranceName() + ", ");
        }
    }

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

    public AuthenticationStatus loggedIn() {
        return this.authenticationStatus;
    }

    public abstract void addInsurance(Insurance i);

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public String getType() {
        return type;
    }
}
