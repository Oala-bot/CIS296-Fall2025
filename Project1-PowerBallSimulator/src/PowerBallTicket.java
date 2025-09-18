import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PowerBallTicket {
    private final ArrayList<Integer> whiteNumbers;
    private final int redNumber;

    public final int COST_PER_TICKET = 2;
    private final int NUMBER_OF_WHITE_NUMBERS = 5;
    private final int MAX_WHITE_NUMBER = 69;

    private final int MAX_RED_NUMBER = 26;

    public final int JACKPOT = 2000000000;
    public final int FIVE_WHITE_MATCHES_PRIZE = 1000000;
    public final int FOUR_WHITE_AND_RED_PRIZE = 50000;
    public final int FOUR_WHITE_OR_THREE_WHITE_AND_RED_PRIZE = 100;
    public final int THREE_WHITE_OR_TWO_WHITE_AND_RED_PRIZE = 7;
    public final int RED_MATCH = 4;
    public final int YOU_LOSE = 0;


    public PowerBallTicket() {
        Random random = new Random();
        whiteNumbers = new ArrayList<>();
        while ( whiteNumbers.size() < NUMBER_OF_WHITE_NUMBERS){
            int randomNumber = random.nextInt(1, MAX_WHITE_NUMBER + 1);
            if ( !whiteNumbers.contains(randomNumber) ) {
                whiteNumbers.add(randomNumber);
            }
        }
        redNumber = random.nextInt(1, MAX_RED_NUMBER + 1);
    }

    public PowerBallTicket(ArrayList<Integer> whiteNumbers, int redNumber) {
        validateWhiteNumbers(whiteNumbers);
        if ( redNumber < 1  || redNumber > MAX_RED_NUMBER ){
            throw new IllegalArgumentException("Red number can't be less than 1 or greater than 26");
        }

        this.whiteNumbers = whiteNumbers;
        this.redNumber = redNumber;
    }

    public int getWinnings(PowerBallTicket winningTicket){
        int whiteMatches = getWhiteMatches(winningTicket);
        boolean redMatches = redNumber == winningTicket.getRedNumber();

        if ( whiteMatches == 5 && redMatches ){
            return JACKPOT;
        } else if ( whiteMatches == 5 ){
            return FIVE_WHITE_MATCHES_PRIZE;
        } else if ( whiteMatches == 4 && redMatches ){
            return FOUR_WHITE_AND_RED_PRIZE;
        } else if ( whiteMatches == 4 || ( whiteMatches == 3 && redMatches )){
            return FOUR_WHITE_OR_THREE_WHITE_AND_RED_PRIZE;
        } else if ( whiteMatches == 3 || ( whiteMatches == 2 && redMatches )) {
            return THREE_WHITE_OR_TWO_WHITE_AND_RED_PRIZE;
        } else if ( redMatches ) {
            return RED_MATCH;
        } else {
            return YOU_LOSE;
        }
    }

    private int getWhiteMatches(PowerBallTicket winningTicket) {
        int whiteMatches = 0;
        for ( int number : whiteNumbers ){
            if ( winningTicket.getWhiteNumbers().contains(number )){
                whiteMatches++;
            }
        }
        return whiteMatches;
    }

    @Override
    public String toString() {
        return "PowerBallTicket{" +
                "whiteNumbers=" + whiteNumbers +
                ", redNumber=" + redNumber +
                '}';
    }

    public ArrayList<Integer> getWhiteNumbers() {
        // Shallow copy, but it's only integers so that's ok
        return (ArrayList<Integer>) whiteNumbers.clone();
    }

    public int getRedNumber() {
        return redNumber;
    }

    private void validateWhiteNumbers(ArrayList<Integer> whiteNumbers) {
        for ( int number : whiteNumbers){
            if ( number < 1 || number > MAX_WHITE_NUMBER ){
                throw new IllegalArgumentException("Number can't be less than 1 or greater than 69");
            }
            // bing "java count of item occurrences in arraylist"
            if ( Collections.frequency(whiteNumbers, number) > 1 ){
                throw new IllegalArgumentException("Number can't be repeated");

            }
        }
    }
}
