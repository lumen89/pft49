package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testModificationContact() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactEdition();
        app.getContactHelper().fillContactForm(new ContactData("edit_first name 1", "edit_middle name 1", "edit_last name 1", "edit_nickname 1", "edit_title 1", "edit_company 1", "edit_address 1", "11111111", "2222222", "33333333", "44444444", "edit_email1@test.com", "edit_email2@test.com", "edit_email3@test.com", "edit_localhost.com", "1889", "2000", "edit_secondary address 1", "edit_test notes"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
