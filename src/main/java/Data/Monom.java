package main.java.Data;

public class Monom {

    private Integer coeficient;
    private Integer exponent;

    public Monom(int coeficient, int exponent){
        this.coeficient = coeficient;
        this.exponent = exponent;
    }

    public Integer getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(Integer coeficient) {
        this.coeficient = coeficient;
    }

    public Integer getExponent() {
        return exponent;
    }

    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }
}
