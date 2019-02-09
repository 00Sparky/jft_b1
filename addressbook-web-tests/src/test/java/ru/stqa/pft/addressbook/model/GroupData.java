package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String groupName;
    private final String groupHeader;
    private final String goupFooter;

    public GroupData(String groupName, String groupHeader, String goupFooter) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.goupFooter = goupFooter;
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
}
