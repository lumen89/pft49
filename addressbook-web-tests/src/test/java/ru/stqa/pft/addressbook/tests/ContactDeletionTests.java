package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstName("first name 1")
                    .withMiddlename("middle name 1")
                    .withLastName("last name 1")
                    .withNickname("nickname 1")
                    .withTitle("title 1")
                    .withCompany("company 1")
                    .withAddress("address 1")
                    .withHome("9999999")
                    .withMobile("8888888")
                    .withWork("77777777")
                    .withFax("6666666")
                    .withEmail("email1@test.com")
                    .withEmail2("email2@test.com")
                    .withEmail3("email3@test.com")
                    .withHomepage("localhost.com")
                    .withBYear("1988")
                    .withAYear("2015")
                    .withAddress2("secondary address 1")
                    .withNotes("test notes")
                    .withGroup("edit_group 1"), true);
        }
    }

    @Test
    public void testDeletionContact() {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().home();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);


    }



}
