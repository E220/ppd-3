package strategies;

import matrix.Matrix;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class Strategy3 extends Strategy {

    public Strategy3(Matrix matrix_a, Matrix matrix_b, int groupCount) {
        super(matrix_a, matrix_b, groupCount);
    }

    @Override
    public List<List<Pair>> getTasks() {
        final List<List<Pair>> tasks = new ArrayList<>(this.groupCount);
        final int resultSize = this.resultDimensions.row() * this.resultDimensions.col();
        for (int group = 0; group < groupCount; group++) {
            tasks.add(new ArrayList<>());
        }
        for (int index = 0, group = 0; index < resultSize; index++, group = ++group % groupCount) {
            final int row = index / this.resultDimensions.col();
            final int col = index % this.resultDimensions.col();
            tasks.get(group).add(new Pair(row, col));
        }
        return tasks;
    }
}
