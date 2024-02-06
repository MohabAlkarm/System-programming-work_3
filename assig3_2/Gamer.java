package assig3_2;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class Gamer extends Thread {
    private int goodFlipCounter;
    private GamePlay gamePlay;

    public Gamer(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
        this.goodFlipCounter = 0;
    }

    public void run() {
        while (!isInterrupted() && gamePlay.getNumOfRounds() < 10) {
            synchronized (gamePlay) {
                while (!gamePlay.isCoin_available()) {
                    try {
                        System.out.println(getName() + " is waiting for coin");
                        gamePlay.wait();
                    } catch (InterruptedException e) {
                        interrupt();
                        break;
                    }

                }
                int flipResult = gamePlay.flipCoin();
                if (flipResult == 1) {
                    goodFlipCounter++;
                }
                gamePlay.notifyAll();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    public int getScore() {
        return goodFlipCounter;
    }
}
