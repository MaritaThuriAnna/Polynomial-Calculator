package main.java.Data;

import java.util.HashMap;
import java.util.Map;

public class Polynom {

    private Map<Integer, Integer> P1;
    public Polynom(Map<Integer, Integer> P1){
        this.P1 = P1;
    }
    public Map<Integer, Integer> getP1() {
        return P1;
    }

    public static Polynom add(Polynom P1, Polynom P2) {

        Map<Integer, Integer> thisExplicit = new HashMap<>(P1.getP1());
        P1.getP1().forEach((exponent, coefficient) ->{
            thisExplicit.put(exponent, coefficient);
        });

        Map<Integer, Integer> p2Explicit = new HashMap<>();
        P2.getP1().forEach((exponent, coefficient) -> {
            p2Explicit.put(exponent, coefficient);
        });

        Map<Integer, Integer> result = new HashMap<>();
        thisExplicit.forEach((exponent, coefficient) -> {
            if (p2Explicit.containsKey(exponent)) {
                coefficient += p2Explicit.get(exponent);
                p2Explicit.remove(exponent);
            }
            result.put(exponent, coefficient);

        });

        p2Explicit.forEach((key, value) -> result.put(key, value));
        return new Polynom(result);
    }

    public static Polynom substract(Polynom P1, Polynom P2){

        Map<Integer, Integer> resultSub = new HashMap<>(P1.getP1());
        P2.getP1().forEach((exponent2, coefficient2) -> {
            int currentCoefficient = resultSub.getOrDefault(exponent2, 0);
            resultSub.put(exponent2, currentCoefficient - coefficient2);
        });
        return new Polynom(resultSub);
    }


    public static Polynom multiply(Polynom P1, Polynom P2){

        Map<Integer, Integer> rezultMul = new HashMap<>();
        P1.getP1().forEach((exponent1, coefficient1) -> {
            P2.getP1().forEach((exponent2, coefficient2) -> {
                int exponent = exponent1 + exponent2;
                int coefficient = coefficient1 * coefficient2;
                rezultMul.compute(exponent, (key, value) -> (value == null) ? coefficient : value + coefficient);
            });
        });
        return new Polynom(rezultMul);
    }

    public static Polynom derivative(Polynom P1) {

        Map<Integer, Integer> resultTerms = new HashMap<>();
        for (Map.Entry<Integer, Integer> term : P1.getP1().entrySet()) {
            int exponent = term.getKey();
            int coefficient = term.getValue();
            if (exponent > 0) {
                resultTerms.put(exponent - 1, exponent * coefficient);
            }
        }
        return new Polynom(resultTerms);
    }



    @Override
    public String toString() {
        String output = "";
        boolean isFirstTerm = true;
        for (int exponent : P1.keySet()) {
            int coefficient = P1.get(exponent);
            if (coefficient == 0) {
                continue;
            }
            if (isFirstTerm) {
                isFirstTerm = false;
                if (coefficient < 0) {
                    output += "-";
                }
            } else {
                output += coefficient < 0 ? " - " : " + ";
            }
            int absCoefficient = Math.abs(coefficient);
            if (absCoefficient != 1 || exponent == 0) {
                output += absCoefficient;
            }
            if (exponent > 0) {
                output += "x";
                if (exponent > 1) {
                    output += "^" + exponent;
                }
            }
        }
        if (output.isEmpty()) {
            output = "0";
        }
        return output;
    }

}
