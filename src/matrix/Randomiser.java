package matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomiser {

    private static final Random random = new Random();

    public static Matrix getRandomMatrix(int rows, int cols, int max) {
        final List<List<Integer>> items = new ArrayList<>(rows);
        for (int row = 0; row < rows; row++) {
            items.add(new ArrayList<>(cols));
            for (int col = 0; col < cols; col++) {
                items.get(row).add(random.nextInt(max));
            }
        }
        return new Matrix(items);
    }
}
