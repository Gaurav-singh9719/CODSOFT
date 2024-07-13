import java.util.Scanner;

public class GuessNumberGame1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        int totalAttempts = 0; // Initialize total attempts across rounds

        do {
            int attempts = playRound(scanner);
            totalAttempts += attempts; // Update total attempts
            displayResult(attempts, totalAttempts); // Display result for the round
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        } while (playAgain);

        System.out.println("Thanks for playing! Your total score (based on attempts) is: " + totalAttempts);
        scanner.close();
    }

    private static int playRound(Scanner scanner) {
        // Generate a random number between 1 and 100 (inclusive)
        int randomNumber = (int) (Math.random() * 100) + 1;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I've generated a random number between 1 and 100.");
        System.out.println("Try to guess it!");
        System.out.println("****The Total number of attempts are: 7.****");

        int userGuess;
        int attempts = 0;
        final int maxAttempts = 7; // Set the maximum number of attempts

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < randomNumber) {
                System.out.println("Try a higher number.");
            } else if (userGuess > randomNumber) {
                System.out.println("Try a lower number.");
            } else {
                System.out.println("Congratulations! You guessed it right!");
                return attempts; // Return the number of attempts
            }
        }

        System.out.println("Sorry, you've reached the maximum number of attempts.");
        System.out.println("The correct number was: " + randomNumber);
        return maxAttempts; // Return the maximum attempts
    }

    private static void displayResult(int attempts, int totalAttempts) {
        if (attempts == 1) {
            System.out.println("You are a genius! You guessed it in just one attempt.");
        } else if (attempts <= 3) {
            System.out.println("Great job! You guessed it in " + attempts + " attempts.");
        } else if (attempts <= 5) {
            System.out.println("Not bad! You guessed it in " + attempts + " attempts.");
        } else {
            System.out.println("Keep practicing! You reached the maximum attempts.");
        }

        System.out.println("Total attempts so far: " + totalAttempts);
    }
}
