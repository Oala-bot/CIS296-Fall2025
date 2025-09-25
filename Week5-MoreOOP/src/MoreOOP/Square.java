package MoreOOP;

public class Square extends Rectangle {
    public Square(){
        super();
    }

    public Square(double length) {
        super(length, length);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setSideLength(int sideIndex,  double sideLength) {
        setLength(sideLength);
        setWidth(sideLength);
    }
}
