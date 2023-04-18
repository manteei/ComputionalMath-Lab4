package ErrValue;

import Storage.Storage;

public class ErrValue {
    private int errNumber;
    private int findWorst(double[]x, double[]y, int n){
        int number = 0;
        double maxError = 0;
        for (int i = 0; i < x.length; i++){
            double err = Math.abs(y[i] - Storage.getFunction(x[i], n));
            if (err > maxError){
                maxError = err;
                number = i;
            }
        }
        return number;
    }

    public double[][] getNewValue(double[]x, double[]y, int n){
        errNumber = findWorst(x, y, n);
        double[] xResult = new double[x.length-1];
        double[] yResult = new double[y.length-1];
        int counter = 0;
        for (int i = 0; i < x.length; i ++){
            if (i != errNumber){
                xResult[counter] = x[i];
                yResult[counter] = y[i];
                counter++;
            }
        }
        return new double[][]{xResult, yResult};
    }

    public int getErrNumber() {
        return errNumber;
    }
}
