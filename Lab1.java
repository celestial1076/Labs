// Антошенко Д.Е. №1 вариант
// Лаба №1
// Финальный варик
// Импорт сканера (ввод с консоли)
import java.util.Scanner;

public class Lab1 {
// Расчет факториала
    public static int CalculateFactorial(int n) {
        int factorial = 1, i = 2;
        while (i <= n) { // Условие
            factorial *= i;
            i++; // Увеличиваем на единицу множитель
        }
        return factorial;
    }
// Делаем возможность вводить искомое число
    public static void  main(String[] args) {
        int number;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число: ");
        number = scan.nextInt();
        System.out.println("Факториал числа " + number + " равен: " + CalculateFactorial(number));
    }
}
