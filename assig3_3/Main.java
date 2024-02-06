package assig3_3;

import java.util.Scanner;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018
public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		// YOUR CODE HERE: use threads to prepare N salads (as the user requested)
		SlicerMachine slicerMachine = new SlicerMachine(numOfSaladsToPrepare);
		TomatoesThread tomatoesThread = new TomatoesThread(slicerMachine);
		CucumbersThread cucumbersThread = new CucumbersThread(slicerMachine);
		SlicerThread slicerThread = new SlicerThread(slicerMachine, tomatoesThread, cucumbersThread);
		slicerThread.start();
		tomatoesThread.start();
		cucumbersThread.start();
		try {
			slicerThread.join();
			tomatoesThread.join();
			cucumbersThread.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("Done");
		scan.close();
	}

}
