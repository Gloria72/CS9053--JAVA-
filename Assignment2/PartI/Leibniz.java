public class Leibniz {

    // 给定迭代次数，按莱布尼茨级数估算 π
    public static double estimatePi(int iterations) {
        if (iterations <= 0) return 0.0;
        double sum = 0.0;
        for (int k = 0; k < iterations; k++) {
            double term = ((k & 1) == 0 ? 1.0 : -1.0) / (2.0 * k + 1.0);
            sum += term;
        }
        return 4.0 * sum;
    }

    public static void main(String[] args) {
        int iterations = 0;
        final double TOL = 1e-5;
        final int MAX_ITERS = 100_000_000;

        // 自动寻找达到误差≤1e-5所需的最小项数
        double sum = 0.0, approx = 0.0;
        int k = 0;
        while (k < MAX_ITERS) {
            double term = ((k & 1) == 0 ? 1.0 : -1.0) / (2.0 * k + 1.0);
            sum += term;
            approx = 4.0 * sum;
            if (Math.abs(Math.PI - approx) <= TOL) {
                iterations = k + 1;
                break;
            }
            k++;
        }
        if (iterations == 0) iterations = MAX_ITERS;

        double pi = estimatePi(iterations);
        System.out.printf("iterations = %d%n", iterations);
        System.out.printf("pi_estimate = %.10f%n", pi);
        System.out.printf("abs_error   = %.10f%n", Math.abs(Math.PI - pi));
    }
}
