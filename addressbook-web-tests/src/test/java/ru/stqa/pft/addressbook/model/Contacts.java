package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<UserData_Mainpage> {

    private Set<UserData_Mainpage> deligate;

    public Contacts(Contacts contacts) {
        this.deligate = new HashSet<UserData_Mainpage>(contacts.deligate);
    }

    public Contacts() {
        this.deligate = new HashSet<UserData_Mainpage>();
    }

    @Override
    protected Set<UserData_Mainpage> delegate() {
        return deligate;
    }

    public Contacts withAdded(UserData_Mainpage contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(UserData_Mainpage contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
