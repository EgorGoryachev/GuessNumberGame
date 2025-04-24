import java.util.Scanner;
public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;

        System.out.println("Выбери тип игрока:");
        System.out.println("1 - Человек");
        System.out.println("2 - Алгоритм");

        int choice = scanner.nextInt();
        Player player;

        if (choice == 1) {
            player = new RealPlayer();
        } else {
            player = new ComPlayer(min, max);
        }

        Game game = new Game(min, max, player);
        game.play();
    }
}
