package assig3_3;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class CucumbersThread extends Thread {

    private SlicerMachine slicerMachine;

    public CucumbersThread(SlicerMachine slicerMachine) {
        this.slicerMachine = slicerMachine;
    }

    public void run() {
        while (!isInterrupted()) {
            synchronized (slicerMachine) {
                while (slicerMachine.numOfCucumbers >= 3) {
                    try {
                        slicerMachine.wait();
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
                slicerMachine.addOneCucumber();
            }
        }
    }
}
