package ru.stqa.pft.addressbook.tests;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group 1", "group header 1", "group footer 1"));
        }
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("edit_group 1", "edit_group header 1", "edit_group footer 1"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after);
    }
    }
