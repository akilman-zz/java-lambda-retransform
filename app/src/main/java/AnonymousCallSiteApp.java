/**
 * POJO application illustrating behavior in translating runtime generated lambda instances.
 *
 * This class covers instrumenting a lambda instance referring to an anonymous call site.
 */
public class AnonymousCallSiteApp {

    public static void main(String[] args) throws InterruptedException {

        Runnable r = () -> {
            System.out.println(".");
        };

        while (true) {
            r.run();
            Thread.sleep(1000);
        }
    }

}
