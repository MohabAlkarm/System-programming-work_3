package assig3_3;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class TomatoesThread extends Thread {

    private SlicerMachine slicerMachine;

    public TomatoesThread(SlicerMachine slicerMachine) {
        this.slicerMachine = slicerMachine;
    }

    public void run() {
        while (!isInterrupted()) {
            synchronized (slicerMachine) {
                while (slicerMachine.numOfTomatoes >= 3) {
                    try {
                        slicerMachine.wait();
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
                slicerMachine.addOneTomato();

            }

        }

    }
}
