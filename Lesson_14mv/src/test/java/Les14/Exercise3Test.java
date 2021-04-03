package Les14;

import com.sun.source.doctree.SeeTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class Exercise3Test {
    private Lesson14 exercise3;


    @ParameterizedTest
    @MethodSource("args3")
    void truefalse2(int[] arr) {
        Assertions.assertTrue(exercise3.exercise3(arr));
    }

    static Stream<Arguments> args3() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 1, 3, 5, 1, 4, 6}),
                Arguments.arguments(new int[]{2, 5, 3, 5, 7, 4, 6}),
                Arguments.arguments(new int[]{2, 8, 5, 8, 9, 10}),
                Arguments.arguments(new int[]{1, 1, 1, 4, 4, 5, 6, 1, 8})
        );
    }
}