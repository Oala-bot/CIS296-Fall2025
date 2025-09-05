import static org.junit.jupiter.api.Assertions.*;

class Week2Test {

    @org.junit.jupiter.api.Test
    void testGetTotalPriceWithTax() {
        // AAA - Arrange, Act, Assert

        // Arrange - setup the variables we need to test
        double expectedTotalPriceWithTax = 5.3;
        double price = 5;

        // Act - call the code we're testing
        double actualTotalPriceWithTax = Week2.getTotalPriceWithTax(price);

        // Assert - did we get what we expected
        assertEquals(expectedTotalPriceWithTax, actualTotalPriceWithTax, .000001);
    }

    @org.junit.jupiter.api.Test
    void testGetTotalPriceWithTaxSpecified() {
        // AAA - Arrange, Act, Assert

        // Arrange - setup the variables we need to test
        double expectedTotalPriceWithTax = 5.5;
        double price = 5;
        double taxRate = 10;

        // Act - call the code we're testing
        double actualTotalPriceWithTax =
                Week2.getTotalPriceWithTax(price, taxRate);

        // Assert - did we get what we expected
        assertEquals(expectedTotalPriceWithTax, actualTotalPriceWithTax);

    }
}