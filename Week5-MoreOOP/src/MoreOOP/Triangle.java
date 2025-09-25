package MoreOOP;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle extends Polygon {
    public Triangle() {
        super(3);
    }

    public Triangle(double size1Length, double side2Length, double side3Length){
        super(new ArrayList<Double>(Arrays.asList(size1Length, side2Length, side3Length)));
    }


    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        ArrayList<Double> sideLengths = getSideLengths();
        return Math.sqrt(semiPerimeter
                *(semiPerimeter-sideLengths.get(0))
                *(semiPerimeter-sideLengths.get(1))
                *(semiPerimeter-sideLengths.get(2)));
    }
}
