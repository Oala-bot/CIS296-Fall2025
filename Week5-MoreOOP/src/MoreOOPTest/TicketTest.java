package MoreOOPTest;

import MoreOOP.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void getNumber() {
        // Arrange
        int[] numbers = {1,2,3};
        Ticket ticket = new Ticket(new NotRandom(numbers));

        // Act
        int actualNumber1 = ticket.getNumber1();
        int actualNumber2 = ticket.getNumber2();
        int actualNumber3 = ticket.getNumber3();

        // Assert
        assertEquals(numbers[0], actualNumber1);
        assertEquals(numbers[1], actualNumber2);
        assertEquals(numbers[2], actualNumber3);

    }
}