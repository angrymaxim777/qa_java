package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private int inputKittensCount;
    private int expectedKittensCount;

    public FelineParameterizedTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0},
                {1, 1},
                {3, 3},
                {10, 10},
                {100, 100}
        });
    }

    @Test
    public void testGetKittensWithDifferentCounts() {
        Feline feline = new Feline();
        assertEquals("getKittens(count) должен возвращать переданное количество котят",
                expectedKittensCount, feline.getKittens(inputKittensCount));
    }
}
