import java.util.Random;
import java.util.Scanner;

public class Guess_Number {
    
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    
    public static void main(String[] args) {
        System.out.println("-----------NUMBER GAME-----------");
        System.out.println("Game Information:");
        System.out.println("You will have 10 chances to guess the number in each round.");
        System.out.println("There are a total of 3 rounds.");
        System.out.println("To win Round 1, you need to make 2 correct guesses.");
        System.out.println("To win Round 2, you need to make 4 correct guesses.");
        System.out.println("To win Round 3, you need to make 6 correct guesses.");
        System.out.println("Choose the difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        
        int level = scanner.nextInt();
        
        switch (level) {
            case 1:
                playGame(1, 5);
                break;
            case 2:
                playGame(1, 10);
                break;
            case 3:
                playGame(1, 20);
                break;
            default:
                System.out.println("Invalid level chosen. Exiting...");
                break;
        }
        
        scanner.close();
    }
    
    static void playGame(int min, int max) {
        int rounds = 0;
        
        if (rounds < 3) {
            int correctGuesses = 0;
            System.out.println("---------ROUND " + (rounds + 1) + "---------");
            for (int chances = 1; chances <= 10; chances++) {
                int randomNumber = random.nextInt(max - min + 1) + min;
                System.out.println("Guess the number between " + min + " and " + max + ". Chance Number " + chances);
                int guess = scanner.nextInt();
                if (guess == randomNumber) {
                    System.out.println("Correct guess!");
                    correctGuesses++;
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                if (correctGuesses >= (2 + rounds * 2)) {
                    System.out.println("Congratulations! You have entered Round " + (rounds + 2));
                    rounds++;
                    break;
                }
            }
        }
        
        if (rounds < 3) {
            int correctGuesses = 0;
            System.out.println("---------ROUND " + (rounds + 1) + "---------");
            for (int chances = 1; chances <= 10; chances++) {
                int randomNumber = random.nextInt(max - min + 1) + min;
                System.out.println("Guess the number between " + min + " and " + max + ". Chance Number " + chances);
                int guess = scanner.nextInt();
                if (guess == randomNumber) {
                    System.out.println("Correct guess!");
                    correctGuesses++;
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                if (correctGuesses >= (2 + rounds * 2)) {
                    System.out.println("Congratulations! You have entered Round " + (rounds + 2));
                    rounds++;
                    break;
                }
            }
        }
        
        if (rounds < 3) {
            int correctGuesses = 0;
            System.out.println("---------ROUND " + (rounds + 1) + "---------");
            for (int chances = 1; chances <= 10; chances++) {
                int randomNumber = random.nextInt(max - min + 1) + min;
                System.out.println("Guess the number between " + min + " and " + max + ". Chance Number " + chances);
                int guess = scanner.nextInt();
                if (guess == randomNumber) {
                    System.out.println("Correct guess!");
                    correctGuesses++;
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                if (correctGuesses >= (2 + rounds * 2)) {
                    System.out.println("Congratulations! You have entered Round " + (rounds + 2));
                    rounds++;
                    break;
                }
            }
        }
        
        System.out.println("Congratulations, your score is " + ((rounds + 1) * 25) + ".");
        System.out.println("Number of Rounds completed: " + (rounds + 1));
        System.out.println("Thank you");
    }
}
