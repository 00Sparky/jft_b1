package ru.stqa.pft.sandbox;

public class HelloWorldProgram {

    public static void main(String[] args) {
        hello("World");
        hello("user");

        Square s=new Square(21.2);
        System.out.println("Площадь квадрата ("+s.l+ ") ="+ s.area());


        Rectangle r= new Rectangle(4.6,1.8);
        System.out.println("Площадь прямоугольника ("+ r.a+ ", "+r.b+ ") ="+ r.area());


    }

    public static void hello(String username) {
        System.out.println("Hello," + username +"! I`m working.");

    }

}
