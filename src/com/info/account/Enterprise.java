package com.info.account;

public class Enterprise extends Account{
    public Enterprise(User user) {
        super(user);
    }

    /**
     * kullanıcının sigorta poliçesi ekleyebilmesi için soyut (abstract) bir
     * fonksiyon tanımlanacaktır. Bu soyut fonksiyon "Individual" ve "Enterprise"
     * isimli alt sınıflarda override edilerek doldurulacaktır. Çünkü, bireysel
     * ve kurumsal müşterilerin ekledikleri paketlerin fiyatlarına uygulanan kar
     * marjı farklı olacaktır.
     */

    @Override
    void addInsurance() {

    }
}
