package methods;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface Method {
    void start(List<Runnable> tasks);
    void join() throws InterruptedException, ExecutionException;
}
