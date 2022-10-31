import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Randomiser {

    private static final Random random = new Random();

    public static <T> Matrix<T> getRandomMatrix(int rows, int cols, Function<Random, T> randomFunction) {
        final List<List<T>> items = new ArrayList<>(rows);
        for (int row = 0; row < rows; row++) {
            items.add(new ArrayList<>(cols));
            for (int col = 0; col < cols; col++) {
                items.get(row).add(randomFunction.apply(random));
            }
        }
        return new Matrix<>(items);
    }
}
