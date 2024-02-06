package assig3_2;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class Main {
    public static void main(String[] args) {
        
        GamePlay game = new GamePlay();
        Gamer p1 = new Gamer(game);
        Gamer p2 = new Gamer(game);
        Judge judge = new Judge(game, p1, p2);
        judge.start();
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
            judge.join();
        } catch (InterruptedException e) {
        }
        if (p1.getScore() == p2.getScore()) {
            System.out.println("tie");
        } else if (p1.getScore() > p2.getScore()) {
            System.out.println("player 1 wins");
        } else {
            System.out.println("player 2 wins");
        }
        
    }
}
