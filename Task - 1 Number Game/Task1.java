import java.util.Random;
import java.util.Scanner;

class Task1 {
    private final Scanner sc;
    private final Random random;
    private int totalScore;
    private int roundNumber;
    
    public Task1() {
        this.sc = new Scanner(System.in);
        this.random = new Random();
        this.totalScore = 0;
        this.roundNumber = 1;
    }
    
    public void startGame() {
        System.out.println("\n\t\t\t\t\tWelcome to the Ultimate Number Guessing Game! ");
        System.out.println("\t\t\t\t Can you outsmart the machine and guess the right number?");
        
        boolean playAgain = true;
        while (playAgain) {
            playRound();
            playAgain = askToPlayAgain();
            if (playAgain) {
                roundNumber++;
            }
        }
        
        endGame();
    }
    
    private void playRound() {
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 7;
        boolean guessedCorrectly = false;
        
        System.out.println("\nRound " + roundNumber + " begins!");
        System.out.println("I have chosen a secret number between 1 and 100. You have " + maxAttempts + " attempts to guess it!");
        
        while (attempts < maxAttempts) {
            System.out.print("\nEnter your guess: ");
            int userGuess = sc.nextInt();
            attempts++;
            
            if (userGuess == numberToGuess) {
                System.out.println(" Bravo! You nailed it in " + attempts + " attempts.");
                totalScore += (maxAttempts - attempts + 1) * 10;
                guessedCorrectly = true;
                break;
            } else {
                giveHint(userGuess, numberToGuess);
            }
            
            System.out.println(" Attempts left: " + (maxAttempts - attempts));
        }
        
        if (!guessedCorrectly) {
            System.out.println("\nOops! You've used all attempts. The secret number was: " + numberToGuess);
        }
        
        System.out.println(" Your current score: " + totalScore);
    }
    
    private void giveHint(int userGuess, int numberToGuess) {
        if (userGuess > numberToGuess) {
            System.out.println(" Too high! Try a smaller number.");
        } else {
            System.out.println(" Too low! Try a larger number.");
        }
    }
    
    private boolean askToPlayAgain() {
        System.out.print("\nWant to challenge yourself again? (Yes/No): ");
        String response = sc.next();
        return response.equals("Yes");
    }
    
    private void endGame() {
        System.out.println("\nGame Over! Your final score: " + totalScore);
        System.out.println("\n\t\t\t\t\t THANK YOU FOR PLAYING! SEE YOU NEXT TIME! ");
        sc.close();
    }
    
    public static void main(String[] args) {
        Task1 game = new Task1();
        game.startGame();
    }
}
