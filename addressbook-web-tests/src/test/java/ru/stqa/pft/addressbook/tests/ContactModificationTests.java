package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testModificationContact() {
        app.getNavigationHelper().goToHomePage();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("first name 1", "middle name 1", "last name 1", "nickname 1", "title 1", "company 1", "address 1", "9999999", "8888888", "77777777", "6666666", "email1@test.com", "email2@test.com", "email3@test.com", "localhost.com", "1988", "2015", "secondary address 1", "test notes", "edit_group 1"), true);
        }
        List<ContactData> before =  app.getContactHelper().getContactList();
        app.getContactHelper().initContactEdition();
        app.getContactHelper().fillContactForm(new ContactData("edit_first name 1", "edit_middle name 1", "edit_last name 1", "edit_nickname 1", "edit_title 1", "edit_company 1", "edit_address 1", "11111111", "2222222", "33333333", "44444444", "edit_email1@test.com", "edit_email2@test.com", "edit_email3@test.com", "edit_localhost.com", "1889", "2000", "edit_secondary address 1", "edit_test notes", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after =  app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

    }
}
