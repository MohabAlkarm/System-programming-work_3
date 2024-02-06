package assig3_3;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class SlicerThread extends Thread {

    private SlicerMachine slicerMachine;
    private TomatoesThread tomatoesThread;
    private CucumbersThread cucumbersThread;

    public SlicerThread(SlicerMachine slicerMachine, TomatoesThread tomatoesThread, CucumbersThread cucumbersThread){
        this.slicerMachine = slicerMachine;
        this.cucumbersThread = cucumbersThread;
        this.tomatoesThread = tomatoesThread;
    }
    public void run(){

        while (slicerMachine.getRequestedSaladsNum() != slicerMachine.getNumOfPreparedSalads()) {
            synchronized(slicerMachine){
                slicerMachine.sliceVegetables();
            }
        }
        tomatoesThread.interrupt();
        cucumbersThread.interrupt();
    }

}
