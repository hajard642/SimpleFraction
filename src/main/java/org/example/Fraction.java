package org.example;

public class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);
    @Override
    public String toString() {
        return "Je suis une fraction.";
    }
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double doubleValue() {
        return (double) numerator / denominator;
    }

    public Fraction add(Fraction other) {
        int newNumerator = numerator * other.denominator
                + other.numerator * denominator;

        int newDenominator = denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Fraction)) {
            return false;
        }

        Fraction other = (Fraction) obj;

        return numerator * other.denominator
                == other.numerator * denominator;

    }
    @Override
    public int compareTo(Fraction other) {
        return Integer.compare(
                numerator * other.denominator,
                other.numerator * denominator
        );
    }
}