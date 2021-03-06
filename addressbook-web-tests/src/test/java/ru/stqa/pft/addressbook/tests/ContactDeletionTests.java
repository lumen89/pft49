package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
                    .withGroup("edit_group 1"), true);
        }
    }

    @Test
    public void testDeletionContact() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().home();

        assertThat(app.contact().count(), equalTo(before.size() - 1));

        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));


    }



}
