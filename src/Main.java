import matrix.Matrix;
import methods.ThreadMethod;
import methods.ThreadPoolMethod;
import problem.Problem;
import program.Program;
import strategies.Strategy1;
import strategies.Strategy2;
import strategies.Strategy3;
import utils.Timer;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final Random random = new Random();
        final Timer timer = new Timer();
        final int runs = 100;

        final Matrix matrix_a = new Matrix(3, 4, () -> random.nextInt(10));
        final Matrix matrix_b = new Matrix(4, 7, () -> random.nextInt(10));

        new Problem(new ThreadMethod(), new Strategy2(matrix_a, matrix_b, 3), timer, runs).run(matrix_a, matrix_b);

        System.out.println();

        new Problem(new ThreadPoolMethod(9), new Strategy1(matrix_a, matrix_b, 5), timer, runs).run(matrix_a, matrix_b);

        System.out.println();

        new Problem(new ThreadPoolMethod(2), new Strategy3(matrix_a, matrix_b, 6), timer, runs).run(matrix_a, matrix_b);
    }
}