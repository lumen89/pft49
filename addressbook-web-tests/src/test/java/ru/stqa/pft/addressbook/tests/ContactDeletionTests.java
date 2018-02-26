package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("first name 1", "middle name 1", "last name 1", "nickname 1", "title 1", "company 1", "address 1", "9999999", "8888888", "77777777", "6666666", "email1@test.com", "email2@test.com", "email3@test.com", "localhost.com", "1988", "2015", "secondary address 1", "test notes", "edit_group 1"), true);
        }
        app.getContactHelper().initContactEdition(before.size() - 1);
        app.getContactHelper().deleteSelectContacts();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

    }

}
