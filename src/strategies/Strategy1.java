package strategies;

import matrix.Matrix;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class Strategy1 extends Strategy {

    public Strategy1(Matrix matrix_a, Matrix matrix_b, int groupCount) {
        super(matrix_a, matrix_b, groupCount);
    }

    @Override
    public List<List<Pair>> getTasks() {
        final List<List<Pair>> tasks = new ArrayList<>(this.groupCount);
        final int resultSize = this.resultDimensions.row() * this.resultDimensions.col();
        final int tasksPerGroup = (int) Math.ceil(1.0 * resultSize / this.groupCount);
        int index = 0;
        for (int group = 0; group < groupCount; group++) {
            tasks.add(new ArrayList<>());
            for (int i = 0; i < tasksPerGroup && index < resultSize; i++, index++) {
                final int row = index / this.resultDimensions.col();
                final int col = index % this.resultDimensions.col();
                tasks.get(group).add(new Pair(row, col));
            }
        }
        return tasks;
    }
}
