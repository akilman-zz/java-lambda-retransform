/**
 * POJO application illustrating behavior in translating runtime generated lambda instances.
 *
 * This class covers instrumenting a lambda instance referring to an instance method reference call site.
 */
public class InstanceMethodCallSiteApp {

    public static void main(String[] args) throws InterruptedException {

        InstanceMethodCallSiteApp app = new InstanceMethodCallSiteApp();
        Runnable r = app::doWork;

        while (true) {
            r.run();
            Thread.sleep(1000);
        }
    }

    public void doWork() {
        System.out.println(".");
    }
}
