package MoreOOP;

import java.util.ArrayList;

public abstract class Polygon {
   // protected int numberOfSides;
    private final int numberOfSides;
    private final ArrayList<Double> sideLengths;

    public Polygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        sideLengths = new ArrayList<>(numberOfSides);
    }

    public Polygon( ArrayList<Double> sideLengths) {
        this.numberOfSides = sideLengths.size();
        for ( double sideLength : sideLengths ) {
            if ( sideLength <= 0 ) {
                throw new IllegalArgumentException( "sideLength must be > 0" );
            }
        }
        this.sideLengths = (ArrayList<Double>) sideLengths.clone();
    }

    public ArrayList<Double> getSideLengths() {
        return (ArrayList<Double>) sideLengths.clone();
    }

    public void setSideLength(int index, double length) {
        if ( length <= 0 ) {
            throw new IllegalArgumentException( "length must be > 0" );
        }
        sideLengths.set(index, length);
    }

    public double getPerimeter() {
        double sum = 0;
        for ( double side : sideLengths ) {
            sum += side;
        }
        return sum;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public abstract double getArea();
}
