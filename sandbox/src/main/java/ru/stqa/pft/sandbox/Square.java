package ru.stqa.pft.sandbox;

public class Square {

    public double l;

    public  Square(double length) {
        this.l=length;
    }
    public double area() {
        return this.l*this.l;
    }
}
