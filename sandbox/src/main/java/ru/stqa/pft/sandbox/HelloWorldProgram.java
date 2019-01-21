package ru.stqa.pft.sandbox;

public class HelloWorldProgram {

    public static void main(String[] args) {
        hello("World");
        hello("user");

    }

    public static void hello(String username) {
        System.out.println("Hello," + username +"! I`m working.");

    }
    public static double area(double l) {
        return l*l;
    }

}
