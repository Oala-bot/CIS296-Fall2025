package MoreOOP;

import java.util.Random;

public class RandomWrapper implements RandomNumbers {
    Random random;

    public RandomWrapper(){
        random = new Random();
    }

    @Override
    public int nextInteger(int lowerBound, int upperBound) {
       return random.nextInt(lowerBound, upperBound);
    }
}
