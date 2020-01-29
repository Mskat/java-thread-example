public class Countdown {

}

class Person {

    public void personCountsDown(String name) {
        System.out.println(name + " is starting the countdown...");
        for(int i = 5; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Countdown is over.");
    }

}
