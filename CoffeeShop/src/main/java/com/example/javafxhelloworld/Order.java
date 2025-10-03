package com.example.javafxhelloworld;

public class Order {

    public static double COFFEE_PRICE = 3;
    public static double ESPRESSO_PRICE = 3.5;
    public static double AMERICANO_PRICE = 4;
    public static double SOY_MILK_PRICE = .5;



    private BeverageType beverageType;
    private boolean hasCream;
    private boolean hasSugar;
    private boolean hasMilk;
    private boolean hasSoyMilk;

    public Order(BeverageType beverageType){
        hasCream = false;
        hasSugar = false;
        hasMilk = false;
        hasSoyMilk = false;
        this.beverageType = beverageType;
    }

    public double getPrice(){
        double price = 0;
        if ( beverageType == BeverageType.coffee){
            price += COFFEE_PRICE;
        } else if ( beverageType == BeverageType.espresso){
            price += ESPRESSO_PRICE;
        } else if ( beverageType == BeverageType.americano){
            price += AMERICANO_PRICE;
        }
        if (hasSoyMilk){
            price += SOY_MILK_PRICE;
        }

        return price;
    }

    @Override
    public String toString() {
        String beverage = "";
        if (beverageType == BeverageType.coffee){
            beverage = "coffee";
        }
        else if (beverageType == BeverageType.espresso){
            beverage = "espresso";
        }
        else if (beverageType == BeverageType.americano){
            beverage = "americano";
        }
        if (hasCream){
            beverage += " with cream";
        }
        if (hasMilk){
            beverage += " with milk";
        }
        if (hasSoyMilk){
            beverage += " with soy milk";
        }
        if (hasSugar){
            beverage += " with sugar";
        }
        return beverage + " - $" + getPrice();
    }

    public void setBeverageType(BeverageType beverageType){
        this.beverageType = beverageType;
    }

    public BeverageType getBeverageType(){
        return beverageType;
    }

    public boolean isHasCream() {
        return hasCream;
    }

    public void setHasCream(boolean hasCream) {
        this.hasCream = hasCream;
    }

    public boolean isHasSugar() {
        return hasSugar;
    }

    public void setHasSugar(boolean hasSugar) {
        this.hasSugar = hasSugar;
    }

    public boolean isHasMilk() {
        return hasMilk;
    }

    public void setHasMilk(boolean hasMilk) {
        this.hasMilk = hasMilk;
    }

    public boolean isHasSoyMilk() {
        return hasSoyMilk;
    }

    public void setHasSoyMilk(boolean hasSoyMilk) {
        this.hasSoyMilk = hasSoyMilk;
    }
}
