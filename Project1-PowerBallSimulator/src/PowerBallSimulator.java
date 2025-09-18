import java.util.ArrayList;

public class PowerBallSimulator {
    private int totalSpent;
    private int totalWon;

    public PowerBallSimulator(){
        totalSpent = 0;
        totalWon = 0;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public int getTotalWon() {
        return totalWon;
    }

    public int getTotalLoss(){
        return totalWon - totalSpent;
    }

    public String playWithChosenNumbers(ArrayList<Integer> whiteNumbers, int redNumber){
        try{
            PowerBallTicket ticket = new PowerBallTicket(whiteNumbers, redNumber);
            PowerBallTicket winningTicket = new PowerBallTicket();

            // this won't work now that we set up clone in the getWhiteNumbers
            winningTicket.getWhiteNumbers().clear();
            winningTicket.getWhiteNumbers().addAll(whiteNumbers);
            int winnings = ticket.getWinnings(winningTicket);

            String result = "Your ticket: " + ticket.toString() + "\n";
            result += "Winning ticket: " + winningTicket.toString() + "\n";
            result += "You won: " + winnings;

            totalSpent += ticket.COST_PER_TICKET;
            totalWon += winnings;

            return result;

        } catch( IllegalArgumentException ex){
            return ex.toString();
        }
    }

    public String playRandomTickets(int numberOfTickets){
        PowerBallTicket winningTicket = new PowerBallTicket();
        StringBuilder result = new StringBuilder();
        for ( int ticketNumber = 0; ticketNumber < numberOfTickets; ticketNumber++ ){
            PowerBallTicket ticket = new PowerBallTicket();

            int winnings = ticket.getWinnings(winningTicket);

            result.append("Your ticket: ").append(ticket.toString()).append("\n");
            result.append("Winning ticket: ").append(winningTicket.toString()).append("\n");
            result.append("You won: ").append(winnings).append("\n");

            totalSpent += ticket.COST_PER_TICKET;
            totalWon += winnings;
        }

        return result.toString();
    }

}
