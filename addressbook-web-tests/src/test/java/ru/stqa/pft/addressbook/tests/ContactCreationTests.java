package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new ContactData().withFirstName("Firstname 3").withLastName("Lastname 3").withAddress("Address 3")});
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new ContactData().withFirstName("Firstname 3").withLastName("Lastname 3").withAddress("Address 3")});
        try(BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.json"))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }


    }

    @Test(dataProvider = "validContactsFromXml")
    public void testContactCreation(ContactData contact) {
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/cm.png");
        /*ContactData contact = new ContactData()
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
                .withPhoto(photo);*/
        app.contact().create(contact, false);


        assertThat(app.contact().count(), equalTo(before.size() + 1));

        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after
                .stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}
