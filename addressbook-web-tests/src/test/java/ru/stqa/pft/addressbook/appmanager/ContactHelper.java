package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
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
        type(By.name("home"), contactData.getHome());

        click(By.name("mobile"));
        type(By.name("mobile"), contactData.getMobile());

        click(By.name("work"));
        type(By.name("work"), contactData.getWork());

        click(By.name("fax"));
        type(By.name("fax"), contactData.getFax());

        click(By.name("email"));
        type(By.name("email"), contactData.getEmail());

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
        returnToHomePage();
    }

    public void delete(int index) {
        initContactEdition(index);
        deleteSelectContacts();
    }

    public void modifyContact(int i, ContactData contact) {
        initContactEdition(i - 1);
        fillContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }


    public void initContactCreation() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
            return;
        }
        click(By.linkText("add new"));
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//*[@name=\"entry\"]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name=\"entry\"]"));
        for (WebElement element : elements) {
         String firstname = element.findElement(By.xpath(".//td[3]")).getText();
         String lastname = element.findElement(By.xpath(".//td[2]")).getText();
         int id = Integer.parseInt(wd.findElement(By.xpath("//*[@name=\"selected[]\"]")).getAttribute("value"));
         ContactData contact = new ContactData()
                 .withtId(id)
                 .withFirstName(firstname)
                 .withLastName(lastname);
         contacts.add(contact);
        }

        return contacts;

    }

}