package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }




    public void fillContactForm(ContactData contactData, boolean creation) {
        click(By.name("firstname"));
        type(By.name("firstname"), contactData.getFirstname());

        click(By.name("middlename"));
        type(By.name("middlename"), contactData.getMiddlename());

        click(By.name("lastname"));
        type(By.name("lastname"), contactData.getLastname());

        click(By.name("nickname"));
        type(By.name("nickname"), contactData.getNickname());

        click(By.name("title"));
        type(By.name("title"), contactData.getTitle());

        click(By.name("company"));
        type(By.name("company"), contactData.getCompany());

        click(By.name("address"));
        type(By.name("address"), contactData.getAddress());

        //click(By.name("theform"));

        click(By.name("home"));
        type(By.name("home"), contactData.getHomePhone());

        click(By.name("mobile"));
        type(By.name("mobile"), contactData.getMobilePhone());

        click(By.name("work"));
        type(By.name("work"), contactData.getWorkPhone());

        click(By.name("fax"));
        type(By.name("fax"), contactData.getFax());

        click(By.name("email"));
        type(By.name("email"), contactData.getEmail1());

        click(By.name("email2"));
        type(By.name("email2"), contactData.getEmail2());

        click(By.name("email3"));
        type(By.name("email3"), contactData.getEmail3());

        click(By.name("homepage"));
        type(By.name("homepage"), contactData.getHomepage());

        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[11]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[11]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
        }
        click(By.name("byear"));
        type(By.name("byear"), contactData.getByear());


        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[5]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[5]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[5]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[5]")).click();
        }

        click(By.name("ayear"));
        type(By.name("ayear"), contactData.getAyear());


        click(By.name("address2"));
        type(By.name("address2"), contactData.getAddress2());

        click(By.name("notes"));
        type(By.name("notes"), contactData.getNotes());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        attach(By.name("photo"), contactData.getPhoto());
    }



    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact() {
        click(By.xpath(".//*[@id='1']"));
    }

    public void deleteSelectContacts() {
        click(By.xpath(".//*[@value='Delete']"));
    }

    public void submitContactModification() {
        click(By.xpath(".//*[@value = \"Update\"][1]"));
    }

    public void initContactEdition(int index) {
        wd.findElements(By.xpath(".//*[@title = 'Edit'][1]")).get(index).click();
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contactData, boolean creation) {
        initContactCreation();
        fillContactForm(contactData, true);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(int index) {
        initContactEdition(index);
        deleteSelectContacts();
    }

    private void initContactEditionByID(int id) {
        wd
                .findElement(By.xpath(".//*[@href=\"edit.php?id=" + id + "\"]"))
                .click();
    }

    public void delete(ContactData contact) {
        initContactEditionByID(contact.getId());
        deleteSelectContacts();
        contactCache = null;
    }


    public void modify(ContactData contact) {
        initContactEditionByID(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        returnToHomePage();
    }


    public void initContactCreation() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
            return;
        }
        click(By.linkText("add new"));
    }

    public int count() {
        return wd.findElements(By.xpath("//*[@name=\"entry\"]")).size();
    }


    private Contacts contactCache = null;

    public Contacts all() {
        if(contactCache != null) {
            return new Contacts (contactCache);
        }
            contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(wd.findElement(By.xpath("//*[@name=\"selected[]\"]")).getAttribute("id"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String adress = cells.get(3).getText(); ;
            String allEmails = cells.get(4).getText();
            contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
                    .withAllPhones(allPhones).withAddress(adress).withAllEmails(allEmails));
        }
        return new Contacts(contactCache);

    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactEditionByID(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).
                withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3);
    }
}