import java.util.Scanner;
import java.util.ArrayList;

public class Week3 {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Chair myChair = new Chair("blue", "Toyota", 60);
        Chair ericsChair = new Chair("black", "staples", 60, 100, 30);
        ericsChair.changeHeight(5);
        System.out.println(ericsChair);

        ArrayList<String> names = new ArrayList<>();
        names.add("Eric");
        names.add("Jeb");
        names.add("Journey");
        names.add(1, "Joy");

        names.remove("Joy");

        // array index vs arraylist methods
        // args[0] = "Eric";
        names.set(0, "ERIC");

        // enhanced for loop
        for ( String name : names ){
            System.out.println(name);
        }

        for ( int index = 0; index < names.size(); index++ ){
            System.out.println(names.get(index));
        }
    }
}
