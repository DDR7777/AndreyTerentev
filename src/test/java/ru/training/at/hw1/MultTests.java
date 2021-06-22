package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTests {
    @DataProvider
    public static Object[][] positiveExamples() {
        return new Object[][]{
                {3, 1, 3},
                {2, 15, 30},
                {4, 0, 0},
                {0, 0, 0},
        };
    }

    @Test(dataProvider = "positiveExamples")
    public void multOfPositiveNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider
    public static Object[][] negativeExamples() {
        return new Object[][]{
                {-5, -1, 5},
                {-10, 27, -270},
                {-7, -15, 105},
                {-0, -0, 0},
        };
    }

    @Test(dataProvider = "negativeExamples")
    public void multOfNegativeNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.mult(a, b);
        Assert.assertEquals(actual,expected);
    }
}
