import java.util.Random;
class Game {
    private int secretNumber;
    private int attempts;
    private Player player;
    private final int minRange;
    private final int maxRange;

    public Game(int minRange, int maxRange, Player player) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.player = player;
        this.attempts = 0;
        generateSecretNumber();
    }

    private void generateSecretNumber() {
        Random random = new Random();
        this.secretNumber = this.minRange + random.nextInt(this.maxRange - this.minRange + 1);
    }

    public void play() {
        System.out.println("Игра началась!Угадай число от " + this.minRange + " до " + this.maxRange);

        while (true) {
            int guess = this.player.makeGuess();
            this.attempts++;

            if (guess == this.secretNumber) {
                System.out.println("Поздравляем!Ты угадал число " + this.secretNumber + " за " + this.attempts + " попыток.");
                break;
            } else if (guess < this.secretNumber) {
                System.out.println("Загаданное число больше!");
                if (this.player instanceof ComPlayer) {
                    ((ComPlayer)this.player).updateRange(false);
                }
            } else {
                System.out.println("Загаданное число меньше!");
                if (this.player instanceof ComPlayer) {
                    ((ComPlayer)this.player).updateRange(true);
                }
            }
        }
    }
}

