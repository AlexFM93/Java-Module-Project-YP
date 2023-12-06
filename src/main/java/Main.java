import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double finalSum;
        String finalList = "Добавленные товары:%s \nИтого сумма: %.2f %s на каждого гостя.";
        Calculator calculator = new Calculator();
        EndFormater formater = new EndFormater();
        CountPeople counter = new CountPeople();

        int countGuests = 1;
        countGuests = counter.countPerson(countGuests);

        while (true) {
            System.out.println("Введите название товара:");
            String countNames = scanner.nextLine().trim();
            while (countNames.isEmpty()) {
                counter.typeErrorMessage();
                countNames = scanner.nextLine().trim();
            }

            double countPrices;
            do {
                System.out.println("Введите стоимость товара, большe нуля.");
                while (!scanner.hasNextDouble()) {
                    counter.typeErrorMessage();
                    scanner.next();
                }
                countPrices = scanner.nextDouble();
            } while (countPrices <= 0);

            calculator.calculate(countNames, countPrices);
            System.out.println("Товар \"" + countNames + "\" успешно добавлен. Хотите добавить ещё один товар? Введите любые символы.\n" + "Или введите \"Завершить\", чтобы завершить процесс добавления товаров.");
            String isFinish = scanner.next();
            scanner.nextLine();
            String finish = "Завершить";
            if (isFinish.equalsIgnoreCase(finish)) {
                finalSum = calculator.price / countGuests;
                System.out.printf((finalList) + "%n", calculator.names, finalSum, formater.formatRubleEnding(finalSum));
                break;
            }
        }
    }
}

class Calculator {
    String names = "";
    double price;

    void calculate(String inputName, double inputPrice) {
        names = names + "\n" + "\"" + inputName + "\"";
        price += inputPrice;
    }
}

class EndFormater {
    String rubles = "руб.";

    String formatRubleEnding(double result) {
        double roundedEnding = Math.floor(result);
        double lefts = roundedEnding % 100;
        double lastDigit = lefts % 10;
        if (((lefts >= 5) && (lefts <= 20)) || (lefts == 0) || ((lastDigit >= 5) && (lastDigit <= 9))) {
            return rubles = "рублей";
        } else {
            if ((lefts == 2) || (lefts == 3) || (lefts == 4) || (lastDigit == 2) || (lastDigit == 3) || (lastDigit == 4)) {
                return rubles = "рубля";
            } else if (((lefts == 1)) || (lastDigit == 1)) {
                return rubles = "рубль";
            }
            return rubles;
        }
    }
}

class CountPeople {
    Scanner scanner = new Scanner(System.in);

    void typeErrorMessage() {
        System.out.println("Это некорректное значение для подсчёта. Попробуйте еще раз.");
    }

    int countPerson(int input) {
        do {
            System.out.println("На скольких человек необходимо разделить счёт? " + "Введите положительное целое число, больше 1.");
            while (!scanner.hasNextInt()) {
                typeErrorMessage();
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input <= 0);
        return input;
    }
}

