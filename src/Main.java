import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(Randomiser.getRandomMatrix(3, 4, Random::nextDouble));
    }
}