import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PowerBallTicketTest {

    @org.junit.jupiter.api.Test
    void getWinningsJackpot() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(whiteNumbers, redNumber);
        int expectedWinnings = ticket.JACKPOT;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinnings5WhiteMatch() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(whiteNumbers, 7);
        int expectedWinnings = ticket.FIVE_WHITE_MATCHES_PRIZE;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinnings4WhiteAndRed() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(6);
        }};
        ArrayList<Integer> winningWhiteNumbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(winningWhiteNumbers, redNumber);
        int expectedWinnings = ticket.FOUR_WHITE_AND_RED_PRIZE;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinnings4White() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(6);
        }};
        ArrayList<Integer> winningWhiteNumbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(winningWhiteNumbers, 7);
        int expectedWinnings = ticket.FOUR_WHITE_OR_THREE_WHITE_AND_RED_PRIZE;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinnings3WhiteAndRed() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(7);
            add(6);
        }};
        ArrayList<Integer> winningWhiteNumbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(winningWhiteNumbers, redNumber);
        int expectedWinnings = ticket.FOUR_WHITE_OR_THREE_WHITE_AND_RED_PRIZE;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinnings3White() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(7);
            add(6);
        }};
        ArrayList<Integer> winningWhiteNumbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(winningWhiteNumbers, 7);
        int expectedWinnings = ticket.THREE_WHITE_OR_TWO_WHITE_AND_RED_PRIZE;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinnings2WhiteAndRed() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(1);
            add(2);
            add(8);
            add(7);
            add(6);
        }};
        ArrayList<Integer> winningWhiteNumbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(winningWhiteNumbers, redNumber);
        int expectedWinnings = ticket.THREE_WHITE_OR_TWO_WHITE_AND_RED_PRIZE;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinningsRed() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(10);
            add(9);
            add(8);
            add(7);
            add(6);
        }};
        ArrayList<Integer> winningWhiteNumbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(winningWhiteNumbers, redNumber);
        int expectedWinnings = ticket.RED_MATCH;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }

    @org.junit.jupiter.api.Test
    void getWinningsYouLose() {
        // Arrange
        // bing "java create array list with items"
        ArrayList<Integer> whiteNumbers = new ArrayList<>() {{
            add(10);
            add(9);
            add(8);
            add(7);
            add(6);
        }};
        ArrayList<Integer> winningWhiteNumbers = new ArrayList<>() {{
            add(4);
            add(3);
            add(2);
            add(1);
            add(5);
        }};
        int redNumber = 6;
        PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
        PowerBallTicket winningTicket = new PowerBallTicket(winningWhiteNumbers, 7);
        int expectedWinnings = ticket.YOU_LOSE;

        // Act
        int actualWinnings = ticket.getWinnings(winningTicket);

        // Assert
        assertEquals(expectedWinnings, actualWinnings);
    }
}