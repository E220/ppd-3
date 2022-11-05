package methods;

import java.util.ArrayList;
import java.util.List;

public class ThreadMethod implements Method {
    private final List<Thread> threads = new ArrayList<>();

    @Override
    public void start(List<Runnable> tasks) {
        tasks.forEach(task -> this.threads.add(new Thread(task)));
        this.threads.forEach(Thread::start);
    }

    @Override
    public void join() throws InterruptedException {
        for (Thread thread : this.threads) {
            thread.join();
        }
    }
}
