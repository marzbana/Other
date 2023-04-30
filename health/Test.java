import java.util.*;

public class Test {

    public static void main(String[] args) {
        int count = 0;
        int total = 10000000;
        double x = 0;
        for (int i = 0; i < total; i++) {
            x = Math.random() * Math.random() * Math.random();
            if (x <= 1) {
                count++;
            }
        }
        System.out.println("Probability of getting less than 1 is: " + (double) count / total);
    }
}
