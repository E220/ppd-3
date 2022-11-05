package matrix;

import utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Matrix {

    private final List<List<Integer>> items;

    public Matrix(List<List<Integer>> items) {
        this.items = items;
    }

    public Matrix(int rows, int cols, Supplier<Integer> supplier) {
        this.items = new ArrayList<>(rows);
        for (int row = 0; row < rows; row++) {
            this.items.add(new ArrayList<>(cols));
            for (int col = 0; col < cols; col++) {
                this.items.get(row).add(supplier.get());
            }
        }
    }

    @Override
    public String toString() {
        return items.stream().map(List<Integer>::toString).collect(Collectors.joining("\n"));
    }

    public int get(Pair pair) {
        return items.get(pair.row()).get(pair.col());
    }

    public void set(Pair pair, int value) {
        items.get(pair.row()).set(pair.col(), value);
    }

    public int getRows() {
        return items.size();
    }

    public int getCols() {
        return items.get(0).size();
    }
}
