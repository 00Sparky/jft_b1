package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
    private  int id;
    private final String groupName;
    private final String groupHeader;
    private final String goupFooter;

    public GroupData( String groupName, String groupHeader, String goupFooter) {
        this.id = 0;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.goupFooter = goupFooter;
    }

    public GroupData(int id, String groupName, String groupHeader, String goupFooter) {
        this.id = id;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.goupFooter = goupFooter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
