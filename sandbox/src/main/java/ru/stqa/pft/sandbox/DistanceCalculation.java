package ru.stqa.pft.sandbox;

public class DistanceCalculation {
    public static void main(String[] args){

        Point p1=new Point(1,2);
        Point p2=new Point(4,6);

        System.out.println("Расстояние между точками = "+Distnance(p1,p2));

        PointMethod d =new PointMethod(1,2,4,6);
        System.out.println("Результат работы метода вычисления расстояния между двумя точками:"+ d.Distnance());

    }


    // функция вычисления расстояния между двумя точками (в одну формулу).
    public static double Distnance (Point p1, Point p2){
        return Math.sqrt(Math.pow((p1.xCoordinate-p2.xCoordinate),2)+Math.pow((p1.yCoordinate-p2.yCoordinate),2));

        /*
        a=(p1.xCoordinate-p2.xCoordinate);
        b=(p1.yCoordinate-p2.yCoordinate);
        aQad=Math.pow(a,2);
        bQad=Math.pow(b,2);
        d=aQuad+bQuad;
        return Math.sqrt(d);
        */
    }

}
