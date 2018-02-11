package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().goToContactPage();
        app.getContactHelper().fillContactForm();
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToGroupPage();
    }

}
