import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countGuests;
        double finalSum;
        String finalList = "Добавленные товары:%s \n%.2f %s";
        Calculator calculator = new Calculator();
        EndFormater formater = new EndFormater();

        System.out.println("На скольких человек необходимо разделить счёт?");
        while(!scanner.hasNextInt()) {
            scanner.next();
            typeErrorMessage();
        }
        countGuests = scanner.nextInt();
        while (countGuests <= 1) {
            typeErrorMessage();
            countGuests = scanner.nextInt();
        }
        while (true) {
            System.out.println("Введите название товара:");
            String countNames = scanner.next();
            System.out.println("Введите цену товара:");
            while(!scanner.hasNextDouble()) {
                scanner.next();
                typeErrorMessage();
            }
            double countPrices = scanner.nextDouble();
            while (countPrices <= 0) {
                typeErrorMessage();
                countPrices = scanner.nextDouble();
            }
            calculator.calculate(countNames, countPrices);
            System.out.println(countNames + " успешно добавлен. Хотите добавить ещё один товар? Введите любой символ.\n"
                    + "Или введите \"Завершить\", чтобы завершить процесс добавления товаров.");
            String isFinish = scanner.next();
            String finish = "Завершить";
            if (isFinish.equalsIgnoreCase(finish)) {
                finalSum = calculator.price / countGuests;
                System.out.printf((finalList) + "%n", calculator.names, finalSum, formater.formatRubleEnding(finalSum));
                break;
            }
        }
    }
    public static class EndFormater {
        String rubles = "рубль.";
        String formatRubleEnding(double result) {
            double ending = Math.floor(result);
            if ((ending >= 0) && (ending < 1)) {
             return rubles = "рублей.";
            }
            if ((ending >= 1) && (ending < 2)) {
               return rubles = "рубль.";
            }
            if ((ending >= 2) && (ending < 5)) {
               return rubles = "рубля.";
            }
            if ((ending >= 5) && (ending < 21)) {
               return rubles = "рублей.";
            } else {
                return rubles = "руб.";
            }
        }
    }
    public static class Calculator {
        String names = "";
        double price;
        void calculate(String inputName, double inputPrice) {
            names = names + "\n" + inputName;
            price += inputPrice;
        }
    }
    public static void typeErrorMessage() {
        System.out.println("Это некорректное значение для подсчёта. Попробуйте еще раз.");
    }
}

