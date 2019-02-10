package ru.stqa.pft.addressbook.model;

public class UserData_Mainpage {
    private final String newUserName;
    private final String newUserLastname;
    private final String newUserAddress;
    private final String newUserMoblle;
    private final String newUserEmail;

    public UserData_Mainpage(String NewUserName, String NewUserLastname, String NewUserAddress, String NewUserMoblle, String NewUserEmail) {
        newUserName = NewUserName;
        newUserLastname = NewUserLastname;
        newUserAddress = NewUserAddress;
        newUserMoblle = NewUserMoblle;
        newUserEmail = NewUserEmail;
    }

    public String getNewUserName() {
        return newUserName;
    }

    public String getNewUserLastname() {
        return newUserLastname;
    }

    public String getNewUserAddress() {
        return newUserAddress;
    }

    public String getNewUserMoblle() {
        return newUserMoblle;
    }

    public String getNewUserEmail() {
        return newUserEmail;
    }
}
