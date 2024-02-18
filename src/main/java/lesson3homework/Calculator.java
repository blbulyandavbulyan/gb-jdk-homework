package lesson3homework;

import java.math.BigDecimal;

public class Calculator {
    public static  <T1 extends Number, T2 extends Number> Number sum(T1 a, T2 b) {
        return new BigDecimal(a.toString()).add(new BigDecimal(b.toString()));
    }
    public static  <T1 extends Number, T2 extends Number> Number multiply(T1 a, T2 b) {
        return new BigDecimal(a.toString()).multiply(new BigDecimal(b.toString()));
    }
    public static  <T1 extends Number, T2 extends Number> Number substract(T1 a, T2 b) {
        return new BigDecimal(a.toString()).subtract(new BigDecimal(b.toString()));
    }
    public static  <T1 extends Number, T2 extends Number> Number divide(T1 a, T2 b) {
        return new BigDecimal(a.toString()).divide(new BigDecimal(b.toString()));
    }
}
