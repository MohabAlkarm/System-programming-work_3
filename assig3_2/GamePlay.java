package assig3_2;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class GamePlay {

    private boolean coin_available_;
    private int rounds_counter_;

    public synchronized boolean isCoin_available() {
        return coin_available_;
    }

    public synchronized void makeCoinAvail(boolean val) {
        this.coin_available_ = val;
        if (val)
            notifyAll();
    }

    public synchronized int flipCoin() {
        int result = 0;
        makeCoinAvail(false);
        System.out.print(Thread.currentThread().getName() + " is flipping coin ");
        rounds_counter_++;
        result = (int)Math.round(Math.random());
        System.out.println("("+result+")");
        makeCoinAvail(true);
        return result;
    }

    public int getNumOfRounds() {
        return rounds_counter_;
    }
}
