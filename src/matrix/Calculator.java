package matrix;

import utils.Pair;

public class Calculator {
    private final Matrix matrix_a;
    private final Matrix matrix_b;

    public Calculator(Matrix matrix_a, Matrix matrix_b) {
        this.matrix_a = matrix_a;
        this.matrix_b = matrix_b;
    }

    public int calculate(Pair pair) {
        int result = 0;
        for (int i = 0; i < matrix_a.getCols(); i++) {
            result += matrix_a.get(new Pair(pair.row(), i)) * matrix_b.get(new Pair(i, pair.col()));
        }
        return result;
    }
}
