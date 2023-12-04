import java.util.Scanner;

class Main {
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
            scanner.nextLine();
            String countNames = scanner.nextLine().trim();
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
    static void typeErrorMessage() {
        System.out.println("Это некорректное значение для подсчёта. Попробуйте еще раз.");
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
    String rubles = "рубль.";
    String formatRubleEnding(double result) {
        double ending = Math.floor(result);
        double lastNumBig = (ending / 100) - (Math.floor(ending / 100));
        double lastNum = lastNumBig * 100;
        if (((lastNum >= 0) && (lastNum < 1)) || ((lastNum >= 5) && (lastNum < 21)) || ((lastNum >= 25) && (lastNum <= 30)) || ((lastNum >= 35) && (lastNum <= 40))) {
            return rubles = "рублей.";
        } else if (((lastNum >= 1) && (lastNum < 2)) || ((lastNum >= 21) && (lastNum < 22)) || ((lastNum >= 31) && (lastNum < 32)) || ((lastNum >= 41) && (lastNum < 42))) {
            return rubles = "рубль.";
        } else if (((lastNum >= 2) && (lastNum < 5)) || ((lastNum >= 22) && (lastNum < 25)) || ((lastNum >= 32) && (lastNum < 35)) || ((lastNum >= 42) && (lastNum < 45))) {
            return rubles = "рубля.";
        } else if (((lastNum >= 45) && (lastNum <= 50)) || ((lastNum >= 55) && (lastNum <= 60)) || ((lastNum >= 65) && (lastNum <= 70)) || ((lastNum >= 85) && (lastNum <= 90))) {
            return rubles = "рублей.";
        } else if (((lastNum >= 51) && (lastNum < 52)) || ((lastNum >= 61) && (lastNum < 62)) || ((lastNum >= 71) && (lastNum < 72)) || ((lastNum >= 91) && (lastNum < 92)) || ((lastNum >= 81) && (lastNum < 82))) {
            return rubles = "рубль.";
        } else if (((lastNum >= 62) && (lastNum < 65)) || ((lastNum >= 72) && (lastNum < 75)) || ((lastNum >= 82) && (lastNum < 85)) || ((lastNum >= 92) && (lastNum < 95))) {
            return rubles = "рубля.";
        } else  if (((lastNum >= 95) && (lastNum < 100)) || ((lastNum >= 75) && (lastNum <= 80))) {
            return rubles = "рублей.";
        } else {
            return rubles = "руб.";
        }
    }
}


