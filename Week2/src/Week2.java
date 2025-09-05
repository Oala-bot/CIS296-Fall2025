import java.util.Scanner;
import java.util.Random;

public class Week2 {

    public static String getInput(String prompt){
        Scanner keyboard = new Scanner(System.in);

        System.out.println(prompt);
        String input = keyboard.nextLine();

        return input;
    }

    public static int getNumberWithinRange(String prompt,
                   int lowerBoundInclusive, int upperBoundExclusive){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(prompt);
        int input = Integer.parseInt(keyboard.nextLine());

        while ( input >= upperBoundExclusive || input < lowerBoundInclusive ){
            System.out.println("Must be between " + lowerBoundInclusive + " and " + upperBoundExclusive);
            System.out.println(prompt);
            input = Integer.parseInt(keyboard.nextLine());
        }

        return input;
    }

    // overload the method, same name, different parameter list
    public static double getTotalPriceWithTax(double price){
        return getTotalPriceWithTax(price, .06);
    }

    public static double getTotalPriceWithTax(double price, double taxRate ){
        if ( taxRate > 100 ){
            throw new IllegalArgumentException("invalid tax rate!");
        }

        if ( taxRate > 1){
            taxRate /= 100;
        }
        return price * ( 1 + taxRate );

    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int number = 10; number > 0; number--){
            System.out.println(random.nextInt(1, 101));
        }
        System.out.println("Blastoff!");

        Scanner keyboard = new Scanner(System.in);

        System.out.println(getTotalPriceWithTax(5));
        try{
            System.out.println(getTotalPriceWithTax(5, 5600));
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }


        System.out.println("Enter your name: ");

        String name;

        // can't use until it's been initialized
        // System.out.println(name);

        // String name = keyboard.nextLine();
        name = keyboard.nextLine();


        name = getInput("Enter your name");

        System.out.println("Hi " + name);

        System.out.println("Enter your age");
        int age = Integer.parseInt(keyboard.nextLine());

        System.out.println("Enter your hourly salary");
        double salary = Double.parseDouble(keyboard.nextLine());

        if (salary > 21) {
            System.out.println("You get a loan!");
        } else if (salary > 18 && age > 25) {
            System.out.println("Maybe get a loan!");
        } else {
            System.out.println("No loan");
        }

        int choice = 0;

        while (choice < 1 || choice > 4) {
            System.out.println("What type of car do you want?");
            System.out.println("1 - Bolt");
            System.out.println("2 - Lamborghini");
            System.out.println("3 - Civic");
            System.out.println("4 - F150");

            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }

        switch (choice) {
            case 1:
                System.out.println("You picked a bolt, you love the planet");
                break;
            case 2:
                System.out.println("You must have some money");
                break;
            case 3:
                System.out.println("A very reasonable car");
                break;
            case 4:
                System.out.println("Want a lift kit too?");
                break;
            default:
                System.out.println("We asked for 1-4 dummy");
        }
        String warranty;
        do {
            System.out.println("Do you want an extended warranty? (Y/N)");
            warranty = keyboard.nextLine();
        } while (!warranty.equalsIgnoreCase("Y")
                && !warranty.equalsIgnoreCase("N"));
    }
}
