package Les14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;


class Exercise1Test {
    private Lesson14 ex1;

    @ParameterizedTest
    @MethodSource("args1")
    void find4(int[] arr1, int[] arr2) {


        Assertions.assertThrows(RuntimeException.class, () -> {
            //Создается условие для проверки на длину массива. Если ошибка, то кидается RuntimeExeption, чтобы в общем тесте было видно и ее тоже
            if (arr1.length != ex1.makeNewArray(arr2).length) {
                System.err.println("Получаемая из метода makeNewArray() длина массива " + Arrays.toString(ex1.makeNewArray(arr2)) + " отличается от ожидаемой " + Arrays.toString(arr1));
                throw new RuntimeException();
            } else Assertions.assertArrayEquals(arr1, ex1.makeNewArray(arr2));
        });
    }

    static Stream<Arguments> args1() {
        return Stream.of(
                Arguments.arguments(new int[]{6}, new int[]{2, 1, 3, 5, 1, 4, 6}),
                Arguments.arguments(new int[]{3, 2, 5, 8}, new int[]{2, 1, 4, 3, 2, 5, 8}),
                Arguments.arguments(new int[]{}, new int[]{2, 8, 5, 8, 9, 10}),
                Arguments.arguments(new int[]{6, 1, 8}, new int[]{1, 1, 1, 4, 4, 5, 6, 1, 8}));
    }

}