package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("group 1", "group header 1", "group footer 1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
