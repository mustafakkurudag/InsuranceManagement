package com.info;

import java.util.ArrayList;

public abstract class Account {
    private enum AuthenticationStatus {
        SUCCESS,
        FAIL
    }
    private User user;
    private ArrayList<Insurance> insurances;


    public final void showUserInfo(User user){}
}
