package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void main(String[] args) {

        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(5);
        Fraction fraction3 = new Fraction();

        assert fraction1.toString().equals("2/3");
        assert fraction2.toString().equals("5/1");
        assert fraction3.toString().equals("0/1");

        System.out.println(fraction1);
        System.out.println(fraction2);
        System.out.println(fraction3);

        //Fraction fraction = new Fraction(2, 3);

        //assert fraction.getNumerator() == 2;
        //assert fraction.getDenominator() == 3;

        Fraction fraction = new Fraction(1, 2);

        assert Math.abs(fraction.doubleValue() - 0.5) < 1E-8;


        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);

        Fraction result = f1.add(f2);

        assert result.getNumerator() == 5;
        assert result.getDenominator() == 6;
    }
}