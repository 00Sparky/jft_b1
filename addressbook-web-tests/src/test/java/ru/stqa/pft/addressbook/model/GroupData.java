package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name="group_list")
public class GroupData {
    @XStreamOmitField
    @Id
    @Column(name="group_id")
    private int id = Integer.MAX_VALUE;

    @Column(name="group_name")
    private String groupName;

    @Column(name="group_header")
    @Type(type="test")
    private String groupHeader;

    @Column(name="group_footer")
   @Type(type="test")
    private String goupFooter;


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
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }
}
