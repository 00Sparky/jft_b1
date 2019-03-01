package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhone(){
        app.goTo().gotoHomepage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getNewUserMoblle(),
                equalTo( cleaned(contactInfoFromEditForm.getNewUserMoblle())));
        assertThat(contact.getNewUserHomephone(),
                equalTo(cleaned(contactInfoFromEditForm.getNewUserHomephone())));
        assertThat(contact.getNewUserWorkphone(),
                equalTo(cleaned(contactInfoFromEditForm.getNewUserWorkphone())));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
