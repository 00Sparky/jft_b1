package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {

    private int id = Integer.MAX_VALUE;
    private String newUserName;
    private String newUserLastname;
    private String newUserAddress;
    private String newUserMoblle;
<<<<<<< HEAD
    private String newUserEmail1;
=======
    private String newUserEmail;
>>>>>>> parent of b393161... Task #11
    private static String group;
    private String NewUserHomephone;
    private String NewUserWorkphone;
    private File photo;


    private String allPhones;

    /*
    public ContactData(String NewUserName, String NewUserLastname, String NewUserAddress, String NewUserMoblle, String NewUserEmail, String Group) {
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

    public String getAllPhones() {
        return allPhones;
    }

    public String getNewUserHomephone() {
        return NewUserHomephone;
    }

    public String getNewUserMoblle() {
        return newUserMoblle;
    }

    public String getNewUserWorkphone() {
        return NewUserWorkphone;
    }

<<<<<<< HEAD
    public String getNewUserEmail1() {
        return newUserEmail1;
    }

    public File getPhoto() {
        return photo;
=======
    public String getNewUserEmail() {
        return newUserEmail;
>>>>>>> parent of b393161... Task #11
    }

    public static String getGroup() {
        return group;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withNewUserName(String newUserName) {
        this.newUserName = newUserName;
        return this;
    }

    public ContactData withNewUserLastname(String newUserLastname) {
        this.newUserLastname = newUserLastname;
        return this;
    }

    public ContactData withNewUserAddress(String newUserAddress) {
        this.newUserAddress = newUserAddress;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withNewUserHomephone(String newUserHomephone) {
        this.NewUserHomephone = newUserHomephone;
        return this;
    }

    public ContactData withNewUserMoblle(String newUserMoblle) {
        this.newUserMoblle = newUserMoblle;
        return this;
    }

    public ContactData withNewUserWorkphone(String newUserWorkphone) {
        this.NewUserWorkphone = newUserWorkphone;
        return this;
    }

<<<<<<< HEAD
    public ContactData withNewUserEmail1(String newUserEmail1) {
        this.newUserEmail1 = newUserEmail1;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
=======
    public ContactData withNewUserEmail(String newUserEmail) {
        this.newUserEmail = newUserEmail;
>>>>>>> parent of b393161... Task #11
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "newUserName='" + newUserName + '\'' +
                ", newUserLastname='" + newUserLastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(newUserName, that.newUserName) &&
                Objects.equals(newUserLastname, that.newUserLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newUserName, newUserLastname);
    }


}
