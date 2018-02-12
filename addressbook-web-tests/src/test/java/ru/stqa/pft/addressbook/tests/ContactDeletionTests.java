package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        app.getNavigationHelper().goToGroupPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectContacts();
        app.getGroupHelper().returnToGroupPage();
    }

}
