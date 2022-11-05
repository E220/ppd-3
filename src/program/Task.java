package program;

import matrix.Calculator;
import matrix.Matrix;
import utils.Pair;

import java.util.List;

public class Task implements Runnable {
    private final Matrix matrix_a;
    private final Matrix matrix_b;

    private final Matrix result;
    private final List<Pair> group;

    public Task(Matrix matrix_a, Matrix matrix_b, Matrix result, List<Pair> group) {
        this.matrix_a = matrix_a;
        this.matrix_b = matrix_b;
        this.result = result;
        this.group = group;
    }

    @Override
    public void run() {
        final Calculator calculator = new Calculator(matrix_a, matrix_b);
        group.forEach(pair -> result.set(pair, calculator.calculate(pair)));
    }
}
