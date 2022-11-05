package utils;

public class Timer {
    private long tick;

    public void start() {
        this.tick = System.nanoTime();
    }
    public void measure() {
        System.out.println((System.nanoTime() - this.tick) / 1000.0 + "ms");
    }
}
