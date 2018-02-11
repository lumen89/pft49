package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }


    public void goToContactPage() {
        click(By.linkText("add new"));
    }

    public void fillContactForm() {
        click(By.name("firstname"));
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("first name 1");

        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys("middle name 1");

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("last name 1");

        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys("nickname 1");

        wd.findElement(By.name("company")).click();

        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys("title 1");

        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys("company 1");

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys("address 1");

        wd.findElement(By.name("theform")).click();

        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys("9999999");

        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys("8888888");

        wd.findElement(By.name("work")).click();
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys("77777777");

        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys("6666666");

        wd.findElement(By.name("theform")).click();

        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("email@test.com");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("email1@test.com");

        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys("email2@test.com");

        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys("email3@test.com");

        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys("localhost.com");

        wd.findElement(By.name("theform")).click();
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[11]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[11]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys("1988");

        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[5]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[5]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[5]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[5]")).click();
        }
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys("2015");
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[3]")).click();
        }

        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys("secondary address 1");

        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys("notes for test");

    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }
}