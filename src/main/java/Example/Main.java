package main.java.Example;

import main.java.Data.Polynom;
import main.java.Interface.Calculator;

public class Main {
    public static void main(String[] args) {

        //testari pentru operatii


        Polynom p1 = Calculator.parsePolinom("1x^3-2x^2+6x^1-5x^0");
        Polynom p2 = Calculator.parsePolinom("1x^2-1x^0");

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        Polynom sum = Polynom.add(p1, p2);
        System.out.println("p1 + p2: " + sum);

        Polynom sub = Polynom.substract(p1, p2);
        System.out.println("p1 - p2 = " + sub);

        Polynom mul = Polynom.multiply(p1, p2);
        System.out.println("p1 * p2 = " + mul);

        Polynom derivat = Polynom.derivative(p1);
        System.out.println("The derivative of " + p1 + " is " + derivat);

        Calculator calculator = new Calculator(null);
    }


}