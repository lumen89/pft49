package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if(app.group().all().size() == 0) {
            app.group().create(new GroupData()
                    .withName("name 1")
                    .withHeader("header 1")
                    .withFooter("footer 1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before =  app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("edit_group 1")
                .withHeader("edit_header 1")
                .withFooter("edit_footer 1");
        app.group().modify(group);
        Set<GroupData> after =  app.group().all();
        Assert.assertEquals(before.size(), after.size());


        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
