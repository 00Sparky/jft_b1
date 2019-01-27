package ru.stqa.pft.sandbox;

public class Rectangle {

    public double a;
    public double b;

    public Rectangle (double length, double width) {
        this.a=length;
        this.b=width;
    }

    public double area ()
    {
        return this.a*this.b;
    }
}
