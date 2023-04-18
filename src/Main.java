import Approximation.Approximation;
import Approximation.Exponential;
import Approximation.Linear;
import Approximation.Quadratic;
import Chart.ChartDrawer;
import ErrValue.ErrValue;
import Storage.Storage;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Storage storage = new Storage();
        ErrValue errValue = new ErrValue();
        Approximation functionType;
        int number = input.chooseFunction();
        int type = input.getApproximate();
        if (type == 1){
             functionType = new Linear();
        }else if (type == 2){
             functionType = new Exponential();
        }else {
             functionType = new Quadratic();
        }
        double[] result1 = functionType.getCoefficient(storage.getSet(number)[0], storage.getSet(number)[1]);
        double[] result2 = functionType.getCoefficient(errValue.getNewValue(storage.getSet(number)[0], storage.getSet(number)[1], type)[0], errValue.getNewValue(storage.getSet(number)[0], storage.getSet(number)[1], type)[1]);
        ChartDrawer chartDrawer = new ChartDrawer(type, number, result1, result2, errValue.getErrNumber());
        chartDrawer.draw();
    }
}
