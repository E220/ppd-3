import matrix.Matrix;
import matrix.Randomiser;
import strategies.Strategy1;
import strategies.Strategy2;

public class Main {
    public static void main(String[] args) {
        final Matrix matrix_a = Randomiser.getRandomMatrix(3, 4, 7);
        final Matrix matrix_b = Randomiser.getRandomMatrix(4, 7, 8);
        System.out.println(matrix_a);
        System.out.println("");
        System.out.println(matrix_b);
        System.out.println(new Strategy1(matrix_a, matrix_b, 4).getTasks());
        System.out.println(new Strategy2(matrix_a, matrix_b, 4).getTasks());
    }
}