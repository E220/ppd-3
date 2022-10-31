import java.util.List;
import java.util.stream.Collectors;

public class Matrix<T> {

    private final List<List<T>> items;

    public Matrix(List<List<T>> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return items.stream().map(List<T>::toString).collect(Collectors.joining("\n"));
    }

    public T get(int row, int col) {
        return items.get(row).get(col);
    }

    public void set(int row, int col, T value) {
        items.get(row).set(col, value);
    }
}
