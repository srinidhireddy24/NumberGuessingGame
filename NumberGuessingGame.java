import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println(
                    "I'm thinking of a number between " + rangeStart + " and " + rangeEnd + ". Can you guess it?");

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out
                            .println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    System.out.println("Your guess is higher than the target number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Oops! You have reached the maximum number of attempts. The target number was: "
                        + targetNumber);
            }

            System.out.print("Your current score is: " + score);
            System.out.println("\nDo you want to play again? (yes/no)");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing the Number Guessing Game! Your final score is: " + score);
    }
}
