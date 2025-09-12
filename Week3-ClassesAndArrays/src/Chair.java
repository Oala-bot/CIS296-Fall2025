public class Chair {
    private String color;
    private String manufacturer;
    private int heightInCM;
    private int maxHeightInCM;
    private int minimumHeightInCM;

    // no return type on Constructors or init
    public Chair(String color, String manufacturer, int heightInCM,
                 int maxHeightInCM, int minimumHeightInCM) {
        if ( maxHeightInCM < minimumHeightInCM ){
            throw new IllegalArgumentException("Invalid min and max");
        }
        if ( heightInCM < minimumHeightInCM || heightInCM > maxHeightInCM){
            throw new IllegalArgumentException("invalid current height");
        }
        setColor(color);
        this.manufacturer = manufacturer;
        this.heightInCM = heightInCM;
        this.maxHeightInCM = maxHeightInCM;
        this.minimumHeightInCM = minimumHeightInCM;
    }

    // overloaded constructor
    public Chair(String color, String manufacturer, int heightInCM){
        this(color, manufacturer, heightInCM, heightInCM, heightInCM);
    }


    // forceful approach using exceptions
    public void changeHeight(int changeInCM){
        // guard clause for checking invalid state
        if ( heightInCM + changeInCM > maxHeightInCM ||
                heightInCM + changeInCM < minimumHeightInCM ){
            throw new IllegalArgumentException("Invalid Change");
        }
        heightInCM += changeInCM;
    }

//    // nicer way, just returns yes or no it worked
//    public boolean changeHeight(int changeInCM){
//        if ( heightInCM + changeInCM <= maxHeightInCM &&
//                heightInCM + changeInCM >= minimumHeightInCM ){
//            heightInCM += changeInCM;
//            return true;
//        }
//
//        return false;
//    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public int getMaxHeightInCM() {
        return maxHeightInCM;
    }

    public int getMinimumHeightInCM() {
        return minimumHeightInCM;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "color='" + color + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", heightInCM=" + heightInCM +
                ", maxHeightInCM=" + maxHeightInCM +
                ", minimumHeightInCM=" + minimumHeightInCM +
                '}';
    }
}
