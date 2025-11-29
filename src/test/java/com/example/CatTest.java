package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Кошка должна говорить 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();

        assertEquals("Еда должна совпадать с ожидаемой", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);
        cat.getFood();

        verify(feline, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodException() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка получения еды"));

        Cat cat = new Cat(feline);

        try {
            cat.getFood();
            fail("Должно было быть исключение");
        } catch (Exception e) {
            assertEquals("Ошибка получения еды", e.getMessage());
        }
    }
}
