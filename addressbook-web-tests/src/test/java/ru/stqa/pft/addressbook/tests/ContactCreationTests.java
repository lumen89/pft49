package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData("first name 1", "middle name 1", "last name 1", "nickname 1", "title 1", "company 1", "address 1", "9999999", "8888888", "77777777", "6666666", "email1@test.com", "email2@test.com", "email3@test.com", "localhost.com", "1988", "2015", "secondary address 1", "test notes", "edit_group 1");
        app.getContactHelper().fillContactForm(contact, true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));

    }

}
