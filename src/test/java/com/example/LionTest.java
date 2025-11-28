package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue("Самец льва должен иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse("Самка льва не должна иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testGetKittensReturnsCorrectValue() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        int actualKittens = lion.getKittens();

        assertEquals("Количество котят должно совпадать", 3, actualKittens);
    }

    @Test
    public void testGetKittensCallsGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        lion.getKittens();

        verify(feline, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", feline);
        List<String> actualFood = lion.getFood();

        assertEquals("Еда должна совпадать с ожидаемой", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsGetFoodWithPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самка", feline);
        lion.getFood();

        verify(feline, times(1)).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный", feline);
    }

    @Test
    public void testInvalidSexExceptionMessage() {
        try {
            new Lion("Неизвестный", feline);
            fail("Должно было быть выброшено исключение");
        } catch (Exception e) {
            assertEquals("Сообщение об ошибке должно быть корректным",
                    "Используйте допустимые значения пола животного - самец или самка",
                    e.getMessage());
        }
    }
}
