
class ComPlayer extends Player {
    private int min;
    private int max;
    private int lastGuess;

    public ComPlayer(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int makeGuess() {
        this.lastGuess = this.min + (this.max - this.min) / 2;
        System.out.println("Алгоритм предполагает: " + this.lastGuess);
        return this.lastGuess;
    }

    public void updateRange(boolean wasTooHigh) {
        if (wasTooHigh) {
            this.max = this.lastGuess - 1;
        } else {
            this.min = this.lastGuess + 1;
        }
    }
}