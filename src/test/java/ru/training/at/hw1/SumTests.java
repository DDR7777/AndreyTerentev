package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SumTests {

    @DataProvider
    public static Object[][] positiveExamples() {
        return new Object[][]{
                {1, 1, 2},
                {3, 27, 30},
                {15, 15, 30},
                {0, 0, 0},
        };
    }

    @Test(dataProvider = "positiveExamples")
    public void sumOfPositiveNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(a, b);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider
    public static Object[][] negativeExamples() {
        return new Object[][]{
                {-5, 1, -4},
                {-10, -27, -37},
                {-15, -15, -30},
                {-0, -0, 0},
        };
    }

    @Test(dataProvider = "negativeExamples")
    public void sumOfNegativeNumbersTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(a, b);
        Assert.assertEquals(actual,expected);
    }
}
