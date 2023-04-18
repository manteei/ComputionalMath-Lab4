package Chart;
import Storage.Storage;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChartDrawer {
    private int type;
    private int number;
    private double[] result1;
    private double[] result2;
    private int errNumber;
    Color color1 = new Color(44, 44, 246);
    Color color2 = new Color(232, 47, 74);
    Color color3 = new Color(142, 198, 89);
    public ChartDrawer(int type, int number, double[] result1, double[] result2, int errNumber ){
        this.number = number;
        this.type = type;
        this.result1 = result1;
        this.result2 = result2;
        this.errNumber = errNumber;
    }
     public void draw(){
         double[] xData = new double[700];
         double[] yData = new double[700];
         double[] xNewData = new double[700];
         double[] yNewData = new double[700];
         if (number == 1) {
             for (int i = 0; i < 700; i++) {
                 double x = (-100 + i) * 0.1;
                 xData[i] = x;
                 yData[i] = Storage.getLinearFunctionWithCoefficient(x, result1[1], result1[0]);
             }
             for (int i = 0; i < 700; i++) {
                 double x = (-100 + i) * 0.1;
                 xNewData[i] = x;
                 yNewData[i] = Storage.getLinearFunctionWithCoefficient(x, result2[1], result2[0]);
             }
         }else if (number == 2) {
             for (int i = 0; i < 700; i++) {
                 double x  = -0.8 + i * 0.004;
                 xData[i] = x;
                 yData[i] = Storage.getExponentialFunctionWithCoefficient(x, result1[0], result1[1]);
             }
             for (int i = 0; i < 700; i++) {
                 double x = -0.8 + i * 0.004;
                 xNewData[i] = x;
                 yNewData[i] = Storage.getExponentialFunctionWithCoefficient(x, result2[0], result2[1]);
             }
         }else {
             for (int i = 0; i < 700; i++) {
                 double x = (-400 + i) * 0.1;
                 xData[i] = x;
                 yData[i] = Storage.getQuadraticFunctionWithCoefficient(x, result1[0], result1[1], result1[2]);
             }

             for (int i = 0; i < 700; i++) {
                 double x = (-400 + i) * 0.1;
                 xNewData[i] = x;
                 yNewData[i] = Storage.getQuadraticFunctionWithCoefficient(x, result2[0], result2[1], result2[2]);
             }
         }

         XYChart chart = new XYChartBuilder()
                 .width(1000)
                 .height(700)
                 .title("Аппроксимация методом наименьших квадратов")
                 .xAxisTitle("X")
                 .yAxisTitle("Y")
                 .build();
         String name1 = "До исключения\n" + Storage.printFunction(number, result1);
         XYSeries firstApproximationDraw = chart.addSeries(name1, xData, yData);
         firstApproximationDraw.setMarker(SeriesMarkers.NONE);
         firstApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
         firstApproximationDraw.setLineColor(Color.GRAY);

         String name2 = "После исключения\n" + Storage.printFunction(number, result2);
         XYSeries secondApproximationDraw = chart.addSeries(name2, xNewData, yNewData);
         secondApproximationDraw.setMarker(SeriesMarkers.NONE);
         secondApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
         secondApproximationDraw.setLineColor(color3);

         XYSeries points = chart.addSeries("Набор точек", Storage.getSet(number)[0], Storage.getSet(number)[1]);
         points.setMarker(SeriesMarkers.CIRCLE);
         points.setLineStyle(SeriesLines.NONE);
         points.setMarkerColor(color1);

         XYSeries point = chart.addSeries("Точка с наибольшим отклонением", new double[]{Storage.getSet(number)[0][errNumber]}, new double[]{Storage.getSet(number)[1][errNumber]});
         point.setMarker(SeriesMarkers.CIRCLE);
         point.setLineStyle(SeriesLines.NONE);
         point.setMarkerColor(color2);

         new SwingWrapper(chart).displayChart();
     }

}
