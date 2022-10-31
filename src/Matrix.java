import java.util.List;

public class Matrix {
    private final int rows;
    private final int cols;

    private final List<List<Double>> items;

    public Matrix(int rows, int cols, List<List<Double>> items) {
        this.rows = rows;
        this.cols = cols;
        this.items = items;
    }

    public double get(int row, int col) {
        return items.get(row).get(col);
    }

    public void set(int row, int col, double value) {
        items.get(row).set(col, value);
    }
}
