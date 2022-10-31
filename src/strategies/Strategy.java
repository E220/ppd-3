package strategies;

import matrix.Matrix;
import utils.Pair;

import java.util.List;

public abstract class Strategy {

    protected final Matrix matrix_a;
    protected final Matrix matrix_b;

    protected final int groupCount;

    protected final Pair resultDimensions;

    public Strategy(Matrix matrix_a, Matrix matrix_b, int groupCount) {
        if (matrix_a.getCols() != matrix_b.getRows()) {
            throw new IllegalArgumentException("Illegal operands for matrix multiplication");
        }
        this.matrix_a = matrix_a;
        this.matrix_b = matrix_b;
        this.groupCount = groupCount;
        this.resultDimensions = new Pair(this.matrix_a.getRows(), this.matrix_b.getCols());
    }
    public abstract List<List<Pair>> getTasks();
}
