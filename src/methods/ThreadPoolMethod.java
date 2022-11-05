package methods;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMethod implements Method {

    private final ExecutorService pool;
    private final List<Runnable> tasks;

    public ThreadPoolMethod(List<Runnable> tasks, int poolSize) {
        this.pool = Executors.newFixedThreadPool(poolSize);
        this.tasks = tasks;
    }

    @Override
    public void start() {
        this.tasks.forEach(this.pool::execute);
    }

    @Override
    public void join() {
        this.pool.shutdown();
    }
}
