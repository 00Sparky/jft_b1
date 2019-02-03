package ru.stqa.pft.sandbox;


public class Point {
    public double xCoordinate;
    public double yCoordinate;

    public Point(double x, double y){
        this.xCoordinate=x;
        this.yCoordinate=y;
    }

    public double distnance (Point p2) {
       // return Math.sqrt(Math.pow((this.xCoordinate - p2.xCoordinate), 2) + Math.pow((this.yCoordinate - p2.yCoordinate), 2));

        double a;
        double b;
        double aQuad;
        double bQuad;
        double d;


        a=(this.xCoordinate-p2.xCoordinate);
        b=(this.yCoordinate-p2.yCoordinate);
        aQuad=Math.pow(a,2);
        bQuad=Math.pow(b,2);
        d=aQuad+bQuad;
        return Math.sqrt(d);
    }


    }
