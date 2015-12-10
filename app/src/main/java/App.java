
public class App {

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        Runnable r = app::doStuff;

        while (true) {
            r.run();
            Thread.sleep(1000);
        }
    }

    void doStuff() {
        System.out.print(".");
    }
}
