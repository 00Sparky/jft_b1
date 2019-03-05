package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {

    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    private String newUserName;
    private String newUserLastname;
    private String newUserAddress;
    private String newUserMoblle;
    private String newUserEmail1;
    private String newUserEmail2;
    private String newUserEmail3;
    private static String group;
    private String NewUserHomephone;
    private String NewUserWorkphone;
    private File photo;


    private String allPhones;
    private String allEmail;

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

    public String getAllEmail() {
        return allEmail;
    }

    public String getNewUserEmail1() {
        return newUserEmail1;
    }

    public String getNewUserEmail2() {
        return newUserEmail2;
    }

    public String getNewUserEmail3() {
        return newUserEmail3;
    }

    public File getPhoto() {
        return photo;
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

    public ContactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public ContactData withNewUserEmail1(String newUserEmail1) {
        this.newUserEmail1 = newUserEmail1;
        return this;
    }

    public ContactData withNewUserEmail2(String newUserEmail2) {
        this.newUserEmail2 = newUserEmail2;
        return this;
    }

    public ContactData withNewUserEmail3(String newUserEmail3) {
        this.newUserEmail3 = newUserEmail3;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
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
        return id == that.id &&
                Objects.equals(newUserName, that.newUserName) &&
                Objects.equals(newUserLastname, that.newUserLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, newUserName, newUserLastname);
    }
}
