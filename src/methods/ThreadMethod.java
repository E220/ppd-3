package methods;

import java.util.ArrayList;
import java.util.List;

public class ThreadMethod implements Method {
    private final List<Thread> threads;

    public ThreadMethod(List<Runnable> tasks) {
        this.threads = new ArrayList<>(tasks.size());
        tasks.forEach(task -> this.threads.add(new Thread(task)));
    }

    @Override
    public void start() {
        this.threads.forEach(Thread::start);
    }

    @Override
    public void join() throws InterruptedException {
        for (Thread thread : this.threads) {
            thread.join();
        }
    }
}
