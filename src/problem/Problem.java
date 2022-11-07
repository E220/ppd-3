package problem;

import matrix.Matrix;
import methods.Method;
import methods.ThreadMethod;
import program.Program;
import strategies.Strategy;
import strategies.Strategy2;
import utils.Timer;

import java.util.concurrent.ExecutionException;

public class Problem {
    private final Method method;
    private final Strategy strategy;

    private final Timer timer;
    private final int runs;

    public Problem(Method method, Strategy strategy, Timer timer, int runs) {
        this.method = method;
        this.strategy = strategy;
        this.timer = timer;
        this.runs = runs;
    }

    public void run(Matrix matrix_a, Matrix matrix_b) throws ExecutionException, InterruptedException {
        double avg = 0;
        for (int run = 0; run < runs; run++) {
            timer.start();
            final Program program = new Program(new ThreadMethod(), new Strategy2(matrix_a, matrix_b, 3));
            final Matrix result = program.multiply(matrix_a, matrix_b);
            avg += timer.measure();
//            System.out.println(result);
        }
        timer.print(avg / runs);
    }
}
