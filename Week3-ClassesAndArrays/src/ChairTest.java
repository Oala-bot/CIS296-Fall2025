import static org.junit.jupiter.api.Assertions.*;

class ChairTest {

    @org.junit.jupiter.api.Test
    void chairConstructor() {
        // Arrange
        String expectedColor = "blue";
        String expectedManufacturer = "toyota";
        int expectedHeight = 100;
        int expectedMaxHeight = 110;
        int expectedMinHeight = 90;

        Chair chair = new Chair(expectedColor, expectedManufacturer, expectedHeight,
                expectedMaxHeight, expectedMinHeight);

        // Act
        String actualColor = chair.getColor();
        String actualManufacturer = chair.getManufacturer();
        int actualHeight = chair.getHeightInCM();
        int actualMaxHeight = chair.getMaxHeightInCM();
        int actualMinHeight = chair.getMinimumHeightInCM();

        // Assert
        assertEquals(expectedColor, actualColor);
        assertEquals(expectedManufacturer, actualManufacturer);
        assertEquals(expectedHeight, actualHeight);
        assertEquals(expectedMaxHeight, actualMaxHeight);
        assertEquals(expectedMinHeight, actualMinHeight);
    }

    @org.junit.jupiter.api.Test
    void changeHeightValidIncrease() {
        // Arrange
        int startingHeight = 100;
        int heightChange = 10;

        Chair chair = new Chair("", "", startingHeight,
                startingHeight + heightChange , startingHeight - heightChange);
        int expectedHeight = startingHeight + heightChange;

        // Act
        chair.changeHeight(heightChange);
        int actualHeight = chair.getHeightInCM();

        // Assert
        assertEquals(expectedHeight, actualHeight);
    }

    @org.junit.jupiter.api.Test
    void changeHeightValidDecrease() {
        // Arrange
        int startingHeight = 100;
        int heightChange = 10;

        Chair chair = new Chair("", "", startingHeight,
                startingHeight + heightChange , startingHeight - heightChange);
        int expectedHeight = startingHeight - heightChange;

        // Act
        chair.changeHeight(-heightChange);
        int actualHeight = chair.getHeightInCM();

        // Assert
        assertEquals(expectedHeight, actualHeight);
    }

    @org.junit.jupiter.api.Test
    void changeHeightInvalidChange() {
        // Arrange
        int startingHeight = 100;
        int heightChange = 10;

        Chair chair = new Chair("", "", startingHeight);
        int expectedHeight = startingHeight;

        // Act
        assertThrows(IllegalArgumentException.class, () -> chair.changeHeight(heightChange));
        int actualHeight = chair.getHeightInCM();

        // Assert
        assertEquals(expectedHeight, actualHeight);
    }
}