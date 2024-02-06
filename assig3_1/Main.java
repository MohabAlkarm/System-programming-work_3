package assig3_1;

//מואב אלחרם 315059253
//סארה אלחמידי 213006018

/* The main idea is that the three threads share one object
 * the object has two states, one state where its the turn of the first thread where it runs once,
 * the other state implies that its not the turn of the first thread
 * but is a race between the 2nd and 3rd threads,
 * where the 2nd thread can run multiple times.
 * the third runs once and then its the the turn of the 1st thread. 
 */
public class Main {
    public static void main(String[] args) {

        Obj obj = new Obj();
        T1 t1 = new T1(obj);
        T2 t2 = new T2(obj);
        T3 t3 = new T3(obj);
        t1.start();
        t2.start();
        t3.start();

    }
}

class T1 extends Thread {
    Obj obj;

    T1(Obj obj) {
        this.obj = obj;
    }

    public void run() {
        while (true) {

            synchronized (obj) {
                while (obj.getNext() != 0) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // some code...
                System.out.println(getName() + " count " + obj.count);
                obj.increment();
                obj.updateNext();

            }

        }
    }
}

class T2 extends Thread {
    Obj obj;

    T2(Obj obj) {
        this.obj = obj;
    }

    public void run() {
        while (true) {
            synchronized (obj) {
                while (obj.getNext() != 1) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // some code...
                System.out.println(getName() + " count " + obj.count);
                obj.increment();

            }
        }
    }
}

class T3 extends Thread {
    Obj obj;

    T3(Obj obj) {
        this.obj = obj;
    }

    public void run() {
        while (true) {
            synchronized (obj) {
                while (obj.getNext() != 1) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // some code...
                System.out.println(getName() + " count " + obj.count);
                obj.increment();
                obj.updateNext();
            }
        }
    }
}

class Obj {
    int count = 0;
    private int next = 1;

    public void updateNext() {
        this.next = (this.next + 1) % 2;
    }

    public int getNext() {
        return next;
    }

    public synchronized void increment() {
        count++;
        notifyAll();
    }

}
