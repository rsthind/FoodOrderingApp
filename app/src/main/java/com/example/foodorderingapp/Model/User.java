package com.example.foodorderingapp.Model;

public class User {
    private String Name;
    private String Password;
    private String Phone;
    private String IsStaff;

    public User() {

    }

    public User(String nama, String password) {
        this.Name = nama;
        this.Password = password;
        this.IsStaff = "false";
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String nama) {
        Name = nama;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
