package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactEdition();
        app.getContactHelper().deleteSelectContacts();
        app.getNavigationHelper().goToHomePage();
    }

}
