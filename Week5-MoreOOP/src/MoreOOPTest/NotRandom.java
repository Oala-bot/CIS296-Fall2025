package MoreOOPTest;

import MoreOOP.RandomNumbers;

public class NotRandom implements RandomNumbers {
    int[] numbers;
    int currentIndex;

    public NotRandom(int[] numbers)
    {
        this.numbers = numbers;
        currentIndex = 0;
    }

    @Override
    public int nextInteger(int lowerBound, int upperBound) {
        return numbers[currentIndex++];
    }
}
