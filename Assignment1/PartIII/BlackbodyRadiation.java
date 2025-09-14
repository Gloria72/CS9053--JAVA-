public class BlackbodyRadiation {

    // 常量（作业允许用科学计数法）
    static final double H  = 6.626e-34;   // Planck [J·s]
    static final double C  = 3.0e8;       // light speed [m/s]
    static final double KB = 1.381e-23;   // Boltzmann [J/K]

    //
    public static double calculateEnergy(double nu, double T) {
        double numerator   = 2.0 * H * Math.pow(nu, 3) / (C * C);
        double exponent    = (H * nu) / (KB * T);
        double denominator = Math.exp(exponent) - 1.0;
        return numerator / denominator;
    }

    public static void main(String[] args) {
        // 勘误：Betelgeuse 970 nm；Sun 500 nm
        double lambdaBetel = 970e-9;   // m
        double lambdaSun   = 500e-9;   // m

        double nuBetel = C / lambdaBetel;
        double nuSun   = C / lambdaSun;

        double IBetel = calculateEnergy(nuBetel, 3500.0);
        double ISun   = calculateEnergy(nuSun,   5800.0);

        System.out.printf("nu (Betelgeuse) = %.6e Hz%n", nuBetel);
        System.out.printf("nu (Sun)        = %.6e Hz%n", nuSun);
        System.out.printf("I for Betelgeuse = %.8e W·sr^-1·m^-2·Hz^-1%n", IBetel);
        System.out.printf("I for the Sun    = %.8e W·sr^-1·m^-2·Hz^-1%n", ISun);
    }
}