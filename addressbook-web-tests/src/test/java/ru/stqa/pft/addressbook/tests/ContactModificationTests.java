package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().list().size() == 0) {
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
    public void testModificationContact() {
        List<ContactData> before = app.contact().list();
        int i = before.size();
        ContactData contact = new ContactData()
                .withtId(before.get(i - 1).getId())
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
                .withGroup("edit_group 1");
        app.contact().modifyContact(i, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), i);


        before.remove(i - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
