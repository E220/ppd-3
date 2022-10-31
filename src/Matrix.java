import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    private final List<List<Integer>> items;

    public Matrix(List<List<Integer>> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return items.stream().map(List<Integer>::toString).collect(Collectors.joining("\n"));
    }

    public int get(int row, int col) {
        return items.get(row).get(col);
    }

    public void set(int row, int col, int value) {
        items.get(row).set(col, value);
    }

    public int getRows() {
        return items.size();
    }

    public int getCols() {
        return items.get(0).size();
    }
}
