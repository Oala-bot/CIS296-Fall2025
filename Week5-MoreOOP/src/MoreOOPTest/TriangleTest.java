package MoreOOPTest;

import MoreOOP.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getArea() {
        // Arrange
        Triangle triangle = new Triangle(3,4, 5);
        double expectedArea = 6.0;

        // Act
        double actualArea = triangle.getArea();

        // assert
        assertEquals(expectedArea, actualArea, .00000001);
    }
}