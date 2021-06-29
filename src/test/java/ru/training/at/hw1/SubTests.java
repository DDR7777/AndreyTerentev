package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTests {
    @DataProvider
    public static Object[][] positiveExamples() {
        return new Object[][]{
                {3, 1, 2},
                {30, 27, 3},
                {20, 15, 5},
                {0, 0, 0},
        };
    }

    @Test(dataProvider = "positiveExamples")
    public void subOfPositiveNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider
    public static Object[][] negativeExamples() {
        return new Object[][]{
                {-5, -1, -4},
                {-10, -27, 17},
                {-17, -15, -2},
                {-0, -0, 0},
        };
    }

    @Test(dataProvider = "negativeExamples")
    public void subOfNegativeNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sub(a, b);
        Assert.assertEquals(actual,expected);
    }
}
