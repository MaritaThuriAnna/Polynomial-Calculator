package test;

import main.java.Interface.Calculator;
import main.java.Data.Polynom;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class PolynomTest {

    @org.junit.jupiter.api.Test
    void add() {
        assertAll(
                () -> Assertions.assertEquals("0", Polynom.add(Calculator.parsePolinom("0"), Calculator.parsePolinom("0")).toString()),
                () -> Assertions.assertEquals("1", Polynom.add(Calculator.parsePolinom("1"), Calculator.parsePolinom("0")).toString()),
                () -> Assertions.assertEquals("4 + 3x^2", Polynom.add(Calculator.parsePolinom("1x^0+1x^2"), Calculator.parsePolinom("3x^0+2x^2")).toString()),
                () -> Assertions.assertEquals("6 + 6x - x^2 + x^3", Polynom.add(Calculator.parsePolinom("5x^0+6x^1-2x^2+1x^3"), Calculator.parsePolinom("1x^0+x^2")).toString()),
                () -> Assertions.assertEquals("2 + 3x", Polynom.add(Calculator.parsePolinom("1x^0+2x^1"), Calculator.parsePolinom("1x^0+1x^1")).toString()),
                () -> Assertions.assertEquals("-3 + 2x + 4x^2", Polynom.add(Calculator.parsePolinom("-2x^0+x^1+3x^2"), Calculator.parsePolinom("-1x^0+x^1+x^2")).toString()),
                () -> Assertions.assertEquals("1 + 2x + 3x^2 + 4x^3", Polynom.add(Calculator.parsePolinom("1x^0+1x^1+x^2+x^3"), Calculator.parsePolinom("0x^0+1x^1+2x^2+3x^3")).toString()),
                () -> Assertions.assertEquals("2x + 2x^2 + 3x^3", Polynom.add(Calculator.parsePolinom("1x^1+2x^2+3x^3"), Calculator.parsePolinom("1x^1")).toString()),
                () -> Assertions.assertEquals("0", Polynom.add(Calculator.parsePolinom("1x^2"), Calculator.parsePolinom("-1x^2")).toString()),
                () -> Assertions.assertEquals("0", Polynom.add(Calculator.parsePolinom("-3x^3+2x^2+1x^1"), Calculator.parsePolinom("3x^3-2x^2-1x^1")).toString())

        );
    }

    @org.junit.jupiter.api.Test
    void substract() {
        assertAll(
            () -> Assertions.assertEquals("0", Polynom.substract(Calculator.parsePolinom("0"), Calculator.parsePolinom("0")).toString()),
            () -> Assertions.assertEquals("1", Polynom.substract(Calculator.parsePolinom("1"), Calculator.parsePolinom("0")).toString()),
            () -> Assertions.assertEquals("-2 - x^2", Polynom.substract(Calculator.parsePolinom("1x^0+1x^2"), Calculator.parsePolinom("3x^0+2x^2")).toString()),
            () -> Assertions.assertEquals("4 + 6x - 3x^2 + x^3", Polynom.substract(Calculator.parsePolinom("5x^0+6x^1-2x^2+1x^3"), Calculator.parsePolinom("1x^0+x^2")).toString()),
            () -> Assertions.assertEquals("x", Polynom.substract(Calculator.parsePolinom("1x^0+2x^1"), Calculator.parsePolinom("1x^0+1x^1")).toString()),
            () -> Assertions.assertEquals("-1 + 2x^2", Polynom.substract(Calculator.parsePolinom("-2x^0+x^1+3x^2"), Calculator.parsePolinom("-1x^0+x^1+x^2")).toString()),
            () -> Assertions.assertEquals("1 - x^2 - 2x^3", Polynom.substract(Calculator.parsePolinom("1x^0+1x^1+x^2+x^3"), Calculator.parsePolinom("0x^0+1x^1+2x^2+3x^3")).toString()),
            () -> Assertions.assertEquals("2x^2 + 3x^3", Polynom.substract(Calculator.parsePolinom("1x^1+2x^2+3x^3"), Calculator.parsePolinom("1x^1")).toString()),
            () -> Assertions.assertEquals("2x^2", Polynom.substract(Calculator.parsePolinom("1x^2"), Calculator.parsePolinom("-1x^2")).toString()),
            () -> Assertions.assertEquals("2x + 4x^2 - 6x^3", Polynom.substract(Calculator.parsePolinom("-3x^3+2x^2+1x^1"), Calculator.parsePolinom("3x^3-2x^2-1x^1")).toString())

                );
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        assertAll(
            () -> Assertions.assertEquals("0", Polynom.multiply(Calculator.parsePolinom("0"), Calculator.parsePolinom("0")).toString()),
            () -> Assertions.assertEquals("0", Polynom.multiply(Calculator.parsePolinom("1"), Calculator.parsePolinom("0")).toString()),
            () -> Assertions.assertEquals("3 + 5x^2 + 2x^4", Polynom.multiply(Calculator.parsePolinom("1x^0+1x^2"), Calculator.parsePolinom("3x^0+2x^2")).toString()),
            () -> Assertions.assertEquals("5 + 6x + 3x^2 + 7x^3 - 2x^4 + x^5", Polynom.multiply(Calculator.parsePolinom("5x^0+6x^1-2x^2+1x^3"), Calculator.parsePolinom("1x^0+x^2")).toString()),
            () -> Assertions.assertEquals("1 + 3x + 2x^2", Polynom.multiply(Calculator.parsePolinom("1x^0+2x^1"), Calculator.parsePolinom("1x^0+1x^1")).toString()),
            () -> Assertions.assertEquals("2 - 3x - 4x^2 + 4x^3 + 3x^4", Polynom.multiply(Calculator.parsePolinom("-2x^0+x^1+3x^2"), Calculator.parsePolinom("-1x^0+x^1+x^2")).toString()),
            () -> Assertions.assertEquals("x + 3x^2 + 6x^3 + 6x^4 + 5x^5 + 3x^6", Polynom.multiply(Calculator.parsePolinom("1x^0+1x^1+x^2+x^3"), Calculator.parsePolinom("0x^0+1x^1+2x^2+3x^3")).toString()),
            () -> Assertions.assertEquals("x^2 + 2x^3 + 3x^4", Polynom.multiply(Calculator.parsePolinom("1x^1+2x^2+3x^3"), Calculator.parsePolinom("1x^1")).toString()),
            () -> Assertions.assertEquals("-x^4", Polynom.multiply(Calculator.parsePolinom("1x^2"), Calculator.parsePolinom("-1x^2")).toString()),
            () -> Assertions.assertEquals("-x^2 - 4x^3 + 2x^4 + 12x^5 - 9x^6", Polynom.multiply(Calculator.parsePolinom("-3x^3+2x^2+1x^1"), Calculator.parsePolinom("3x^3-2x^2-1x^1")).toString())
         );
    }


    @org.junit.jupiter.api.Test
    void derive(){
        assertAll(
            () -> Assertions.assertEquals("0", Polynom.derivative(Calculator.parsePolinom("0")).toString()),
            () -> Assertions.assertEquals("0", Polynom.derivative(Calculator.parsePolinom("1")).toString()),
            () -> Assertions.assertEquals("2x", Polynom.derivative(Calculator.parsePolinom("1x^0+1x^2")).toString()),
            () -> Assertions.assertEquals("6 - 4x + 3x^2", Polynom.derivative(Calculator.parsePolinom("5x^0+6x^1-2x^2+1x^3")).toString()),
            () -> Assertions.assertEquals("2", Polynom.derivative(Calculator.parsePolinom("1x^0+2x^1")).toString()),
            () -> Assertions.assertEquals("1 + 6x", Polynom.derivative(Calculator.parsePolinom("-2x^0+x^1+3x^2")).toString()),
            () -> Assertions.assertEquals("1 + 2x + 3x^2", Polynom.derivative(Calculator.parsePolinom("1x^0+1x^1+x^2+x^3")).toString()),
            () -> Assertions.assertEquals("1 + 4x + 9x^2", Polynom.derivative(Calculator.parsePolinom("1x^1+2x^2+3x^3")).toString()),
            () -> Assertions.assertEquals("2x", Polynom.derivative(Calculator.parsePolinom("1x^2")).toString()),
            () -> Assertions.assertEquals("1 + 4x - 9x^2", Polynom.derivative(Calculator.parsePolinom("-3x^3+2x^2+1x^1")).toString())
        );
    }

}