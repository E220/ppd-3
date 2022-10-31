public class Main {
    public static void main(String[] args) {
        final Matrix matrix_a = Randomiser.getRandomMatrix(3, 4, 7);
        final Matrix matrix_b = Randomiser.getRandomMatrix(4, 2, 8);
        System.out.println(matrix_a);
        System.out.println("");
        System.out.println(matrix_b);
        System.out.println(new Calculator(matrix_a, matrix_b).calculate(1, 1));
    }
}