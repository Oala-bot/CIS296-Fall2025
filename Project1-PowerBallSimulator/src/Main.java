import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PowerBallSimulator powerBallSimulator = new PowerBallSimulator();

        Scanner keyboard = new Scanner(System.in);
        String choice = "";

        while ( !choice.equals("3") ) {

            System.out.println("Do you want to do:\n1-Pick numbers\n2-Random Numbers\n3-Quit");
            choice = keyboard.nextLine();

            if (choice.equals("1")) {
                ArrayList<Integer> whiteNumbers = new ArrayList<>();
                while (whiteNumbers.size() < 5) {
                    System.out.println("Enter a white number 1-69");
                    whiteNumbers.add(Integer.parseInt(keyboard.nextLine()));
                }
                System.out.println("Enter a red number 1-26");
                int redNumber = Integer.parseInt(keyboard.nextLine());
                System.out.println(powerBallSimulator.playWithChosenNumbers(whiteNumbers, redNumber));

            } else if (choice.equals("2")) {
                System.out.println("How many random tickets do you want?");
                int numberOfTickets = Integer.parseInt(keyboard.nextLine());
                System.out.println(powerBallSimulator.playRandomTickets(numberOfTickets));

            }

            System.out.println("Total Spent: $" + powerBallSimulator.getTotalSpent());
            System.out.println("Total Won: $" + powerBallSimulator.getTotalWon());
            System.out.println("Net Loss: $" + powerBallSimulator.getTotalLoss());
        }
    }
}