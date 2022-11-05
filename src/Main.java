import matrix.Matrix;
import methods.ThreadMethod;
import methods.ThreadPoolMethod;
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

        final Matrix matrix_a = new Matrix(3, 4, () -> random.nextInt(10));
        final Matrix matrix_b = new Matrix(4, 7, () -> random.nextInt(10));

        timer.start();
        final Program program1 = new Program(new ThreadMethod(), new Strategy2(matrix_a, matrix_b, 3));
        timer.measure();
        System.out.println(program1.multiply(matrix_a, matrix_b));

        System.out.println();

        timer.start();
        final Program program2 = new Program(new ThreadPoolMethod(9), new Strategy1(matrix_a, matrix_b, 5));
        timer.measure();
        System.out.println(program2.multiply(matrix_a, matrix_b));

        System.out.println();

        timer.start();
        final Program program3 = new Program(new ThreadPoolMethod(2), new Strategy3(matrix_a, matrix_b, 6));
        timer.measure();
        System.out.println(program3.multiply(matrix_a, matrix_b));
    }
}