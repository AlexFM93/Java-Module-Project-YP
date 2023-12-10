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
            System.out.println("Товар \"" + countNames + "\" успешно добавлен. Хотите добавить ещё один товар? Введите любые символы.\n"
                    + "Или введите \"Завершить\", чтобы завершить процесс добавления товаров.");
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

