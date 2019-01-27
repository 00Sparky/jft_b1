package ru.stqa.pft.sandbox;
/*
Расчет расстояния между двумя точкамии
 */

public class PointMethod {
    public double x1Coordinate;
    public double y1Coordinate;
    public double x2Coordinate;
    public double y2Coordinate;

    public PointMethod(double x1, double y1, double x2, double y2) {
        this.x1Coordinate = x1;
        this.y1Coordinate = y1;
        this.x2Coordinate = x2;
        this.y2Coordinate = y2;
    }

    public double Distnance (){
        return Math.sqrt(Math.pow((this.x1Coordinate-this.x2Coordinate),2)+Math.pow((this.y1Coordinate-this.y2Coordinate),2));
    }

}
