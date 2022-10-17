package com.info.account;

public class Individual extends Account{
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
    void addInsurance() {

    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
