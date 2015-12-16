/**
 * POJO application illustrating behavior in translating runtime generated lambda instances.
 *
 * This class covers instrumenting a lambda instance referring to an static method reference call site.
 */
public class StaticMethodCallSiteApp {

    public static void main(String[] args) throws InterruptedException {

        Runnable r = StaticMethodCallSiteApp::doWork;

        while (true) {
            r.run();
            Thread.sleep(1000);
        }
    }

    public static void doWork() {
        System.out.println(".");
    }
}
