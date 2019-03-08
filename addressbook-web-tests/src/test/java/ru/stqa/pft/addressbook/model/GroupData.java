package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {
    @XStreamOmitField
    @Id
    @Column(name="group_id")
    private int id = Integer.MAX_VALUE;

    @Column(name="group_name")
    private String groupName;

    @Column(name="group_header")
    @Type(type="text")
    private String groupHeader;

    @Column(name="group_footer")
    @Type(type="text")
    private String goupFooter;

    @ManyToMany(mappedBy = "groups")
    private Set<ContactData> contacts = new HashSet<ContactData>();

    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withGoupFooter(String goupFooter) {
        this.goupFooter = goupFooter;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGoupFooter() {
        return goupFooter;
    }

    public Contacts getContacts() {
        return new Contacts(contacts);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName) &&
                Objects.equals(groupHeader, groupData.groupHeader) &&
                Objects.equals(goupFooter, groupData.goupFooter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, groupHeader, goupFooter);
    }
}
