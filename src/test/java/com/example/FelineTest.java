package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Feline должен питаться мясом", expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Feline должен принадлежать к семейству кошачьих", "Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutParameters() {
        Feline feline = new Feline();
        assertEquals("getKittens() без параметров должен возвращать 1", 1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        int expectedCount = 5;
        assertEquals("getKittens(count) должен возвращать переданное количество",
                expectedCount, feline.getKittens(expectedCount));
    }
}
