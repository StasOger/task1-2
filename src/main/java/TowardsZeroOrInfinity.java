import java.math.BigDecimal;
import java.util.Scanner;

public class TowardsZeroOrInfinity {
//Задание 2 "Стремится к нулю или к бесконечности?"
//  (n! обозначает factorial(n))
//  Будет ли выражение вида:
//    un = (1 / n!) * (1! + 2! + 3! + ... + n!)
//  стремится к 0 или к бесконечности?
//  Реализуйте функцию, которая расчитывает значение un для целочисленных n > 1 (с точностью не хуже 6 знаков после запятой).

    public static long getFactorial(long f) {
        if (f <= 1) {
            return  1;
        }
        else {
            return f * getFactorial(f - 1);
        }
    }

    public static void getUn(long n){
// Пусть un = y * x
// Находим y
        BigDecimal y = new BigDecimal(1.0/getFactorial(n));
        BigDecimal x = new BigDecimal(0);
        for (int i=1; i<=n; i++){
// Находим x
            x = x.add(BigDecimal.valueOf(getFactorial(i)));
        }
// Находим un
        BigDecimal un = y.multiply(x);

// Вывод ответа (un) в консоль
        System.out.println("При n = "+ n + ", un = "+ un);
    }

    public static void main(String[] args) {
//Пример
        System.out.println("Пример");
        getUn(3);
        getUn(5);
        getUn(65);

        System.out.println();
        System.out.println("Введите число n (n > 1): ");

        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        getUn(n);
    }
}
