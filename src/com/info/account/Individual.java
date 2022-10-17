package com.info.account;

import com.info.insurance.Insurance;

import java.util.ArrayList;

public class Individual extends Account{
    ArrayList<Insurance> myInsurances = new ArrayList<>();
    public Individual(User user) {
        super(user, "Bireysel");
    }

    /**
     * kullanıcının sigorta poliçesi ekleyebilmesi için soyut (abstract) bir
     * fonksiyon tanımlanacaktır. Bu soyut fonksiyon "Individual" ve "Enterprise"
     * isimli alt sınıflarda override edilerek doldurulacaktır. Çünkü, bireysel
     * ve kurumsal müşterilerin ekledikleri paketlerin fiyatlarına uygulanan kar
     * marjı farklı olacaktır.
     */
    @Override
    public void addInsurance(Insurance i) {
        myInsurances.add(i);
        setInsurances(myInsurances);
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
