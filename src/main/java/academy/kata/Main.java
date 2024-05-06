package academy.kata;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        TipService tipService = new TipService();
        BigDecimal b = BigDecimal.valueOf(5);
        BigDecimal bigDecimal = BigDecimal.valueOf(10);
        System.out.println(b.compareTo(bigDecimal));

    }
}