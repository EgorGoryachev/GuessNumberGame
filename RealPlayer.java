import java.util.Scanner;
import java.util.Random;

public class RealPlayer extends Player{
    private Scanner scanner;

    public RealPlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int makeGuess() {
        System.out.print("Введи свою догадку: ");
        while (!this.scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введи целое число!");
            this.scanner.next(); 
            System.out.print("Введи догадку: ");
        }
        return this.scanner.nextInt();
    }
}

