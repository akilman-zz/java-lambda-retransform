import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.concurrent.*;

public class JavaAgent {

    public static void premain(String args, Instrumentation instrumentation) {

        System.out.println("javaagent in da house!");
        instrumentation.addTransformer(new LambdaTransformer());


        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            Class[] allLoadedClasses = instrumentation.getAllLoadedClasses();
            for (Class clazz : allLoadedClasses) {
                final String name = clazz.getName();
                if (name.contains("$$Lambda$") && name.contains("App")) {
                    try {
                        instrumentation.retransformClasses(clazz);
                    } catch (UnmodifiableClassException e) {
                        e.printStackTrace();
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        };
        pool.schedule(task, 10, TimeUnit.SECONDS);
    }

}
