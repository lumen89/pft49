package ru.stqa.pft.addressbook.tests;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("group 1", "group header 1", "group footer 1"));
        }
        List<GroupData> before =  app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() -1).getId(),"test_n 1", "test_h 2", "test_f 3");
        app.getGroupHelper().fillGroupForm(new GroupData("edit_group 1", "edit_group header 1", "edit_group footer 1"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after =  app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());


        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
    }
