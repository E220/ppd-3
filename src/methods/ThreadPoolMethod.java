package methods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolMethod implements Method {

    private final ExecutorService pool;
    private final List<Runnable> tasks = new ArrayList<>();
    private final List<Future<?>> futures = new ArrayList<>();

    public ThreadPoolMethod(int poolSize) {
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void start(List<Runnable> tasks) {
        this.tasks.addAll(tasks);
        this.tasks.forEach(task -> this.futures.add(this.pool.submit(task)));
    }

    @Override
    public void join() throws InterruptedException, ExecutionException {
        for (Future<?> future : this.futures) {
            future.get();
        }
        this.pool.shutdown();
    }
}
