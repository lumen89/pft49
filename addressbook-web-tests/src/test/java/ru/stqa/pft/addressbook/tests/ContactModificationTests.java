package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testModificationContact() {
        app.getContactHelper().goToContactPage();
        app.getContactHelper().fillContactForm(new ContactData("edit_first name 1", "edit_middle name 1", "edit_last name 1", "edit_nickname 1", "edit_title 1", "edit_company 1", "edit_address 1", "edit_9999999", "edit_8888888", "edit_77777777", "edit_6666666", "edit_email1@test.com", "edit_email2@test.com", "edit_email3@test.com", "edit_localhost.com", "edit_1988", "edit_2015", "edit_secondary address 1", "edit_test notes"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToGroupPage();
    }
}
