import java.util.Scanner;

public class Main {
        public static class EndFormater {
            String rubles = "рубль.";
        }

        public static class Calculator {
            String names = "";
            double price;

            void calculate(String inputName, double inputPrice) {
                names = names + "\n" + inputName;
                price += inputPrice;
            }

        }
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int countGuests;
    double finalSum;
    String ruble = " рубль.";
    String finalList = "Добавленные товары:%s \n%.2f %s";

    System.out.println("На скольких человек необходимо разделить счёт?");
    countGuests = scanner.nextInt();

    while(countGuests <= 1) {
        System.out.println("Это некорректное значение для подсчёта. Попробуйте еще раз.");
        countGuests = scanner.nextInt();
    }

    Calculator calculator = new Calculator();
    EndFormater formater = new EndFormater();

    while(true) {
        System.out.println("Введите название товара:");
        String countNames = scanner.next();

        System.out.println("Введите цену товара:");
        double countPrices = scanner.nextDouble();

        calculator.calculate(countNames, countPrices);

        System.out.println(countNames + " успешно добавлен. Хотите добавить ещё один товар? Введите любой символ.\n"
        + "Или введите \"Завершить\", чтобы завершить процесс добавления товаров.");
        String isFinish = scanner.next();
        String finish = "Завершить";
            if (isFinish.equalsIgnoreCase(finish)) {
                System.out.println(String.format(finalList, calculator.names, calculator.price, formater.rubles));
                break;
            }
        }
    }
}