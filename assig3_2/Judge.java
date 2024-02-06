package assig3_2;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class Judge extends Thread {
    private Gamer p1, p2;
    private GamePlay gamePlay;

    public Judge(GamePlay gamePlay, Gamer p1, Gamer p2) {
        this.gamePlay = gamePlay;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void run() {
        while (!isInterrupted()) {
            gamePlay.makeCoinAvail(false);
            if (gamePlay.getNumOfRounds() >= 10) {
                p1.interrupt();
                p2.interrupt();
                interrupt();
                break;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gamePlay.makeCoinAvail(true);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
