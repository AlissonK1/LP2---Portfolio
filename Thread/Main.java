public class Main implements Runnable {
    public void run() {

        for (int i = 0; i < 4; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            try {
                Thread.sleep(1000);
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t.getName());
        System.out.println("Is Alive? " + t.isAlive());

    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Main());
        t.start();

        Thread t2 = new Thread(new Main());
        t2.start();

        t.join(10000);
        System.out.println("\nJoining after 10000" + " milliseconds: \n");
        System.out.println("Current thread: " + t.getName());
        System.out.println("Current thread: " + t2.getName());
        System.out.println("Is alive? " + t.isAlive());
        System.out.println("Is alive? " + t2.isAlive());
    }
}
