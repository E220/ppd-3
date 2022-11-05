package program;

import matrix.Matrix;
import methods.Method;
import strategies.Strategy;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Program {
    private final Method method;
    private final Strategy strategy;

    public Program(Method method, Strategy strategy) {
        this.method = method;
        this.strategy = strategy;
    }

    public Matrix multiply(Matrix matrix_a, Matrix matrix_b) throws InterruptedException, ExecutionException {
        final Matrix result = new Matrix(matrix_a.getRows(), matrix_b.getCols(), () -> 0);

        final List<List<Pair>> groups = strategy.getTasks();
//        System.out.println(groups);
        final List<Runnable> tasks = new ArrayList<>(groups.size());
        groups.forEach(group -> tasks.add(new Task(matrix_a, matrix_b, result, group)));
        method.start(tasks);
        method.join();

        return result;
    }
}
