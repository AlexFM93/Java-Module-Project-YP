import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double finalSum;
        String finalList = "Добавленные товары:%s \n%.2f %s";
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
            System.out.println("Введите цену товара:");
            while (!scanner.hasNextDouble()) {
                scanner.next();
                counter.typeErrorMessage();
            }
            double countPrices = scanner.nextDouble();
            while (countPrices <= 0) {
                counter.typeErrorMessage();
                countPrices = scanner.nextDouble();
            }
            calculator.calculate(countNames, countPrices);
            System.out.println("Товар \"" + countNames + "\" успешно добавлен. Хотите добавить ещё один товар? Введите любые символы.\n"
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
}

class Calculator {
    String names = "";
    double price;

    void calculate(String inputName, double inputPrice) {
        names = names + "\n" + inputName;
        price += inputPrice;
    }
}

class EndFormater {
    String rubles = "руб.";

    String formatRubleEnding(double result) {
        double roundedEnding = Math.floor(result);
        double lefts = roundedEnding % 100;
        double lastDigit = lefts % 10;
        if (((lefts >= 5) && (lefts <= 20)) || (lefts == 0) ||
                ((lastDigit >= 5) && (lastDigit <= 9))) {
            return rubles = "рублей.";
        } else {
            if ((lefts == 2) || (lefts == 3) || (lefts == 4) ||
                    (lastDigit == 2) || (lastDigit == 3) || (lastDigit == 4)) {
                return rubles = "рубля.";
            } else if (((lefts == 1)) || (lastDigit == 1)) {
                return rubles = "рубль.";
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
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (!scanner.hasNextInt()) {
            scanner.next();
            typeErrorMessage();
        }
        input = scanner.nextInt();
        while (input <= 1) {
            typeErrorMessage();
            input = scanner.nextInt();
        }
        return input;
    }
}