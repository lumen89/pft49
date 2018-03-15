package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/cm.png");
        ContactData contact = new ContactData()
                .withFirstName("first name 1")
                .withMiddlename("middle name 1")
                .withLastName("last name 1")
                .withNickname("nickname 1")
                .withTitle("title 1")
                .withCompany("company 1")
                .withAddress("address 1")
                .withHomePhone("9999999")
                .withMobilePhone("8888888")
                .withWorkPhone("77777777")
                .withFax("6666666")
                .withEmail1("email1@test.com")
                .withEmail2("email2@test.com")
                .withEmail3("email3@test.com")
                .withHomepage("localhost.com")
                .withBYear("1988")
                .withAYear("2015")
                .withAddress2("secondary address 1")
                .withNotes("test notes")
                .withGroup("edit_group 1")
                .withPhoto(photo);
        app.contact().create(contact, false);


        assertThat(app.contact().count(), equalTo(before.size() + 1));

        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after
                .stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}
