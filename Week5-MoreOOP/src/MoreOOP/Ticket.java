package MoreOOP;

public class Ticket {
    RandomNumbers randomNumbers;
    private int number1;
    private int number2;
    private int number3;

    public Ticket(RandomNumbers randomNumbers) {
        number1 = randomNumbers.nextInteger(1, 10);
        number2 = randomNumbers.nextInteger(1, 10);
        number3 = randomNumbers.nextInteger(1, 10);
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber3() {
        return number3;
    }
}
