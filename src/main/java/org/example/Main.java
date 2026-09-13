package org.example;

public class Main {

    public static void main(String[] args) {

        // Tests des constructeurs
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5);
        Fraction fraction3 = new Fraction();

        assert fraction1.getNumerator() == 2;
        assert fraction1.getDenominator() == 3;

        assert fraction2.getNumerator() == 5;
        assert fraction2.getDenominator() == 1;

        assert fraction3.getNumerator() == 0;
        assert fraction3.getDenominator() == 1;

        // Affichage
        System.out.println(fraction1);
        System.out.println(fraction2);
        System.out.println(fraction3);

        // Tests des getters
        Fraction fraction = new Fraction(2, 3);

        assert fraction.getNumerator() == 2;
        assert fraction.getDenominator() == 3;

        // Test de doubleValue()
        Fraction fractionDouble = new Fraction(1, 2);

        assert Math.abs(fractionDouble.doubleValue() - 0.5) < 1E-8;

        // Test de add()
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);

        Fraction result = f1.add(f2);

        assert result.getNumerator() == 5;
        assert result.getDenominator() == 6;

        // Test de equals()
        Fraction f4 = new Fraction(1, 2);
        Fraction f5 = new Fraction(2, 4);
        Fraction f6 = new Fraction(2, 3);

        assert f1.equals(f5);
        assert !f1.equals(f6);

        // Test de compareTo()
        Fraction f7 = new Fraction(1, 2);
        Fraction f8 = new Fraction(2, 3);
        Fraction f9 = new Fraction(1, 2);

        assert f1.compareTo(f8) < 0;
        assert f2.compareTo(f7) > 0;
        assert f1.compareTo(f9) == 0;

        // Test de Number avec BigDecimal
        Number aNumber = java.math.BigDecimal.ONE;
        Number anotherNumber = new Fraction(1, 2);

        assert Math.abs(
                aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5
        ) < 1E-8;
    }
}