package Storage;

import java.text.DecimalFormat;

public class Storage {
    //private static double[] expX = new double[]{ -0.7, -0.5, -0.4, -0.36, -0.29, -0.7, 0.28, 0.47, 0.30, 0.106, 0.209, 0.4, 1.3, 1.8};
    //private static double[] expY = new double[]{ 0.8, 1.2, 1.8, 2.02, 2.5, 4.8, 14, 25, 90, 8.24, 11.232, 19.9, 290, 1423};
    private static double[] expX = new double[]{ -0.5, -0.4, -0.45, -0.37, -0.32, -0.75, 0.29, 0.49, 0.39, 0.2, 0.32, 0.49, 1.17, 1.3};
    private static double[] expY = new double[]{ 0.8, 1.2, 1.8, 2.02, 2.5, 4.8, 14, 25, 90, 8.24, 11.232, 19.9, 290, 1423};
    //private static double[] linX = new double[]{-6.7, -4.77, -1.64, 1.64, 3.32, 7.48,15, 17.3, 24, 30.82, 42.5};
    //private static double[] linY = new double[]{-45.2, -33.6, -14.84, 4.84, 14.92, 39.88,50, 99, 139, 179.92, 250};
    //private static double[] linX = new double[]{-6.1, -3, -1.9, 1.9, 3.9, 7.1,15.2, 17.99, 22.4, 17.8, 42.54};
    //private static double[] linY = new double[]{-45.2, -33.6, -14.84, 4.84, 14.92, 39.88,50, 99, 139, 179.92, 250};
    private static double[] linX = new double[]{5, 6};
    private static double[] linY = new double[]{1, 2};
    private static double[] quaX = new double[]{ -27, -26, -23, -21.6, -17, -14, -4.8, -4.5, 8, 9.34, 10.73, 16.4, -8.3, -11.84, -3, -12, -11.3, -9.4, -6.6,-1.73, -7.1, 13.3};
    private static double[] quaY = new double[]{ 90,75, 46, 34, 5, -10, -15, 30, 60, 74.8, 90.19, 165, -18.8, -15, -10.3, -14.8, -16.2, -18.5, -17.9, -5.75, -18.4, 121.6};
    //private static double[] quaX = new double[]{ -26, -25, -22.5, -21.9, -19, -13, -5, -4, 8.9, 9.9, 10, 16.9, -8.9, -11.84, -3.99, -12.7, -11.9, -9.9, -6.9,-1, -7.9, 12};
    //private static double[] quaY = new double[]{ 90,75, 46, 34, 5, -10, -15, 30, 60, 74.8, 90.19, 165, -18.8, -15, -10.3, -14.8, -16.2, -18.5, -17.9, -5.75, -18.4, 121.6};

    public static double[][] getSet(int n){
        if (n == 1) return new double[][]{linX, linY};
        else if (n == 2) return new double[][]{expX, expY};
        else return new double[][]{quaX, quaY};
    }
    public static double getFunction(double x, int n){
        if (n == 1) return -5+6*x;
        else if (n == 2) return 6*Math.exp(3 * x);
        else return 0.3 * Math.pow(x, 2)+5*x+2;
    }
    public static double getLinearFunctionWithCoefficient(double x, double k, double b){
       return k*x+b;
    }
    public static double getExponentialFunctionWithCoefficient(double x, double k, double b){
        return k*Math.exp(b * x);
    }
    public static double getQuadraticFunctionWithCoefficient(double x, double a, double b, double c){
        return a * Math.pow(x, 2)+b*x+c;
    }
    public static String printFunction(int n, double [] coeff){
        DecimalFormat df = new DecimalFormat("#.####");

        String result;
        if (n == 1)  result = df.format(coeff[0]) + "x + " + df.format(coeff[1]);
        else if (n == 2) result = df.format(coeff[0]) + "e^" + df.format(coeff[1]) +"x";
        else result = df.format(coeff[0]) +  "x^2 + " + df.format(coeff[1]) + "x + " + df.format(coeff[2]);
        return result;
    }

    public static void printSet(){
        //System.out.println("1) y = -5 + 6x");
        System.out.println("1.");
        System.out.print("| X ");
        for (int i = 0; i < linX.length; i++) {
            System.out.printf("|%6.2f", linX[i]);
        }
        System.out.println("|");

        System.out.print("| Y ");
        for (int i = 0; i < linY.length; i++) {
            System.out.printf("|%6.2f", linY[i]);
        }
        System.out.println("|");
        System.out.println("2.");
        //System.out.println("2) y = 6e^3x");
        System.out.print("| X ");
        for (int i = 0; i < expX.length; i++) {
            System.out.printf("|%6.2f", expX[i]);
        }
        System.out.println("|");

        System.out.print("| Y ");
        for (int i = 0; i < expY.length; i++) {
            System.out.printf("|%6.2f", expY[i]);
        }
        System.out.println("|");
        System.out.println("3.");
       // System.out.println("3) 0.3x^2 + 5x + 2");
        System.out.print("| X ");
        for (int i = 0; i < quaX.length; i++) {
            System.out.printf("|%7.2f", quaX[i]);
        }
        System.out.println("|");

        System.out.print("| Y ");
        for (int i = 0; i < quaY.length; i++) {
            System.out.printf("|%7.2f", quaY[i]);
        }
        System.out.println("|");
    }

}
