package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreateNew extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      //String[] split = line.split(";");
      //  list.add(new Object[]{new GroupData().withGroupName(split[0]).withGroupHeader(split[1]).withGoupFooter(split[2])});
      xml+= line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>)xstream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testNewUserCreation(ContactData contact) throws Exception {
    Groups groups = app.db().groups();

    app.goTo().gotoHomepage();
    Contacts before = app.db().contacts();
    app.contact().goToAddNewUserPage();
   // ContactData newContact = new ContactData()
      //      .withNewUserName("test_name").withNewUserLastname("last_name").inGroup(groups.iterator().next());
   // File photo = new File("src/test/resources/file.jpg");
    app.contact().createNewContact(contact, true);

    Assert.assertEquals(app.contact().count(), before.size()+1);
    Contacts after = app.db().contacts();

    Contacts a = before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()));
   // assertThat(after,equalTo(a));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
