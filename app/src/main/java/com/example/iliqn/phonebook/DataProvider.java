package com.example.iliqn.phonebook;

/**
 * Created by iliqn on 3/30/2016.
 */
public class DataProvider {
    private  String name;
    private  String mobile;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public DataProvider(String name,String mobile,String email)
    {
        this.name=name;
        this.mobile=mobile;
        this.email=email;

    }
}
