package ru.stqa.pft.addressbook.model;

public class UserData_Mainpage {

    private final String newUserName;
    private final String newUserLastname;
    private final String newUserAddress;
    private final String newUserMoblle;
    private final String newUserEmail;
    private static String group;

    public UserData_Mainpage(String NewUserName, String NewUserLastname, String NewUserAddress, String NewUserMoblle, String NewUserEmail, String Group) {
        newUserName = NewUserName;
        newUserLastname = NewUserLastname;
        newUserAddress = NewUserAddress;
        newUserMoblle = NewUserMoblle;
        newUserEmail = NewUserEmail;
        group = Group;
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

    public static String getGroup() {
        return group;
    }
}
