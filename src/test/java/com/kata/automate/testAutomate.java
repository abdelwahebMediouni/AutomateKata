package com.kata.automate;

import com.kata.automate.model.Automate;
import com.kata.automate.model.Coordinate;
import com.kata.automate.model.Grid;
import com.kata.automate.model.Orientation;
import org.junit.jupiter.api.*;

import com.kata.automate.model.PivoteDirection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

public class testAutomate {


    private Grid grid;
    private Coordinate coordinate;
    private Automate automate;

    @BeforeEach
    void setUp() {

        grid = new Grid(5, 5);

    }


    @DisplayName("check the automate position after some moves")
    @ParameterizedTest(name = "{index} : For an initial position of :  {0}, and after these instructions : {1}, we end up with this position : {2}  ")
    @CsvSource({"1 2 N,GAGAGAGAA,1 3 N", "3 3 E,AADAADADDA,5 1 E"})
    void testAutomate(String initialPosition, String input, String expected) {

        coordinate = new Coordinate(Integer.valueOf(initialPosition.split(" ")[0]), Integer.valueOf(initialPosition.split(" ")[1]));
        automate = new Automate(coordinate, Orientation.valueOf(initialPosition.split(" ")[2].charAt(0)), grid);

        Stream<Character> characterStream = input.chars().mapToObj(c -> (char) c);
        characterStream.forEach(c -> makeMove(c));
        Assertions.assertEquals(expected, automate.getAutomatePosition() + " " + automate.getAutomateOrientation());
    }

    void makeMove(char action) {
        if ('A' == action) {
            automate.move();
        } else {
            automate.pivoter(PivoteDirection.valueOf(action));
        }
    }


}
