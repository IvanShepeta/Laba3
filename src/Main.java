import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k = 34;  // Задайте значення k (менше 35)
        double s1 = 1.0;  // Задайте значення s1

        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 1; i <= k; i++) {
            double term = Math.log10(Math.sqrt(s1 / (i * i)));
            sum = sum.add(new BigDecimal(term));
        }

        System.out.println("Сума ряду: " + sum);
        System.out.println("Завдання 2");
        task2.tasks();
        task3.tasks();
    }
}

class task2 {
    public static void tasks() {

        task2 secondTaskObj = new task2();

        secondTaskObj.printtaskSolution(12, 9, 1);
        secondTaskObj.printtaskSolution(0, 8, -3);
        secondTaskObj.printtaskSolution(-7, 11, 7);
        secondTaskObj.printtaskSolution(5, 7, 2);
        secondTaskObj.printtaskSolution(0, 13, 0);
        secondTaskObj.printtaskSolution(-16, 5, 8);
    }

    private double solvetask(double t, int n, int l) {
        boolean isItEven = l % 2 == 0;

        if(t == 0 || isItEven && t < 0) {
            throw new IllegalArgumentException("param t = " + t);
        }

        double sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += isItEven ? l / Math.sqrt(t) : l / t;
        }

        return sum;
    }

    private void printtaskSolution(double t, int n, int l) {
        String output = "t=" + t + "; n=" + n + "; l=" + l + ";\nresult: ";

        try {
            output += solvetask(t, n, l);

        } catch(IllegalArgumentException e) {
            output += "EXCEPTION! " + e.getMessage();
        }

        System.out.println(output);
    }
}

class task3 {
    public task3() {
    }

    public static void tasks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення для ε (ε > 0): ");
        double epsilon = scanner.nextDouble();
        if (epsilon <= 0.0) {
            throw new IllegalArgumentException("ε повинно бути більше за 0");
        } else {
            double sum = calculateInfiniteSum(epsilon);
            System.out.println("Результат: " + sum);
        }
    }

    public static double calculateInfiniteSum(double epsilon) {
        double sum = 0.0;
        int i = 1;

        double term;
        do {
            term = Math.pow(-1,i) / calculateFactorial(i);
            sum += term;
            ++i;
        } while(Math.abs(term) >= epsilon);

        return sum;
    }
   public static int calculateFactorial(int i){
        int result = 1;
        for (int n = 1; n <=i; n ++){
            result = result*n;
        }
        return result;
    }
}