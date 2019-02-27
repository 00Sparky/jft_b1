package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class UserData_Mainpage {

    private int id = Integer.MAX_VALUE;
    private String newUserName;
    private String newUserLastname;
    private String newUserAddress;
    private String newUserMoblle;
    private String newUserEmail;
    private static String group;

    /*
    public UserData_Mainpage(String NewUserName, String NewUserLastname, String NewUserAddress, String NewUserMoblle, String NewUserEmail, String Group) {
        newUserName = NewUserName;
        newUserLastname = NewUserLastname;
        newUserAddress = NewUserAddress;
        newUserMoblle = NewUserMoblle;
        newUserEmail = NewUserEmail;
        group = Group;
    }
    */

    public int getId() {
        return id;
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

    public UserData_Mainpage withId(int id) {
        this.id = id;
        return this;
    }

    public UserData_Mainpage withNewUserName(String newUserName) {
        this.newUserName = newUserName;
        return this;
    }

    public UserData_Mainpage withNewUserLastname(String newUserLastname) {
        this.newUserLastname = newUserLastname;
        return this;
    }

    public UserData_Mainpage withNewUserAddress(String newUserAddress) {
        this.newUserAddress = newUserAddress;
        return this;
    }

    public UserData_Mainpage withNewUserMoblle(String newUserMoblle) {
        this.newUserMoblle = newUserMoblle;
        return this;
    }

    public UserData_Mainpage withNewUserEmail(String newUserEmail) {
        this.newUserEmail = newUserEmail;
        return this;
    }

    public UserData_Mainpage withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        return "UserData_Mainpage{" +
                "newUserName='" + newUserName + '\'' +
                ", newUserLastname='" + newUserLastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData_Mainpage that = (UserData_Mainpage) o;
        return Objects.equals(newUserName, that.newUserName) &&
                Objects.equals(newUserLastname, that.newUserLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newUserName, newUserLastname);
    }
}
