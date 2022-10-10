package com.info;

public class InvalidAuthenticationException extends Exception {
    /**
     * Giriş işlemi başarısız ise "InvalidAuthenticationException" tipinde
     * bir hata fırlatacaktır. Bu hata sınıfını Exception isimli Java
     * sınıfından kalıtım alarak sizin yazmanız gerekecektir.
     */
    public InvalidAuthenticationException(String message) {
        super(message);
        System.out.println("Email veya şifre hatası. Tekrar deneyin!");
    }

}
