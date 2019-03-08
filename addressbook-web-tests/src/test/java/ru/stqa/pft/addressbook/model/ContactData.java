package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name="addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name="id")
    private int id = Integer.MAX_VALUE;

    @Column(name="firstname")
    private String newUserName;

    @Column(name = "lastname")
    private String newUserLastname;

    @Column(name="address")
    @Type(type="text")
    private String newUserAddress;

    @Column(name = "home")
    @Type(type="text")
    private String NewUserHomephone;

    @Column(name = "mobile")
    @Type(type="text")
    private String newUserMoblle;

    @Column(name = "work")
    @Type(type="text")
    private String NewUserWorkphone;

    @Column(name="email")
    @Type(type="text")
    private String newUserEmail1;

    @Column(name="email2")
    @Type(type="text")
    private String newUserEmail2;

    @Column(name="email3")
    @Type(type="text")
    private String newUserEmail3;

    @Transient
    private static String group;

    @Column(name = "photo")
    @Type(type="text")
    private String photo;

    @Transient
    private String allPhones;
    @Transient
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
        return new File(photo);
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
        this.photo = photo.getPath();
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
                Objects.equals(newUserLastname, that.newUserLastname) &&
                Objects.equals(newUserAddress, that.newUserAddress) &&
                Objects.equals(NewUserHomephone, that.NewUserHomephone) &&
                Objects.equals(newUserMoblle, that.newUserMoblle) &&
                Objects.equals(NewUserWorkphone, that.NewUserWorkphone) &&
                Objects.equals(newUserEmail1, that.newUserEmail1) &&
                Objects.equals(newUserEmail2, that.newUserEmail2) &&
                Objects.equals(newUserEmail3, that.newUserEmail3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, newUserName, newUserLastname, newUserAddress, NewUserHomephone, newUserMoblle, NewUserWorkphone, newUserEmail1, newUserEmail2, newUserEmail3);
    }
}
