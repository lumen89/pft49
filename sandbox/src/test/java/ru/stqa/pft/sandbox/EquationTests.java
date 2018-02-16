package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test
    public void return0RootTest() {
        Equation equation = new Equation(1, 1, 1);
        Assert.assertEquals(equation.returnRoots(), 0);
    }

    @Test
    public void return1RootTest() {
        Equation equation = new Equation(0,0,0);
         Assert.assertEquals(equation.returnRoots(), 1);
        }

    @Test
    public void return2RootsTest() {
        Equation equation = new Equation(1,5,2);
        Assert.assertEquals(equation.returnRoots(), 2);
    }
}
