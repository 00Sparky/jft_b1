package ru.stqa.pft.sandbox;

public class HelloWorldProgram {

    public static void main(String[] args) {
        hello("World");
        hello("user");

        double side=3;
        System.out.println("Площадь квадрата ("+ side+ ") ="+ area(side));

        double length=2;
        double width=3;

        System.out.println("Площадь прямоугольника ("+ length+ ", "+width+ ") ="+ area(length, width));


    }

    public static void hello(String username) {
        System.out.println("Hello," + username +"! I`m working.");

    }
    public static double area(double l) {
        return l*l;
    }

    public static double area (double a, double b){
       return a*b;
    }
}
