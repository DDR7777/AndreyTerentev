package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideTests {
    @DataProvider
    public static Object[][] positiveExamples() {
        return new Object[][]{
                {3, 1, 3},
                {-0, 15, 0},
                {2, 5, 0},
        };
    }

    @Test(dataProvider = "positiveExamples")
    public void divOfPositiveNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] negativeExamples() {
        return new Object[][]{
                {-5, -1, 5},
                {-10, 2, -5},
                {0, -15, 0},
        };
    }

    @Test(dataProvider = "negativeExamples")
    public void divOfNegativeNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.div(a, b);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] zeroExamples() {
        return new Object[][]{
                {-5},
                {0},
                {3},
        };
    }

    @Test(dataProvider = "zeroExamples")
    public void divByZeroTest(long a) {
        Calculator calculator = new Calculator();
        try {
            calculator.div(a, 0);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), NumberFormatException.class);
        }
    }
}
