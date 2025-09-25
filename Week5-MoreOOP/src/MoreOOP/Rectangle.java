package MoreOOP;

import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle extends Polygon {

    public Rectangle() {
        super(4);
        // only works if the value is marked as protected
        // numberOfSides = 2;
    }

    public Rectangle(double length, double width){
        super(new ArrayList<>(Arrays.asList(length, width, length, width)));
    }

    @Override
    public void setSideLength(int index, double length) {
        if ( index % 2 == 0 ){
            super.setSideLength(0, length);
            super.setSideLength(2, length);
        }
        else {
            super.setSideLength(1, length);
            super.setSideLength(3, length);
        }
    }

    public double getArea(){
        ArrayList<Double> sideLengths = super.getSideLengths();
        return sideLengths.get(0) * sideLengths.get(1);
    }

    public void setLength(double length) {
        setSideLength(0, length);
    }

    public void setWidth(double width) {
        setSideLength(1, width);
    }
}
