package task;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberRangeStart = 1;
        int numberRangeEnd = 100;
        int maxAttempts = 10;
        int score = 0;
        int rounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            int randomNumber = random.nextInt(numberRangeEnd - numberRangeStart + 1) + numberRangeStart;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds + ": Guess the number between " + numberRangeStart + " and " + numberRangeEnd + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    score++;
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();  
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }
}
