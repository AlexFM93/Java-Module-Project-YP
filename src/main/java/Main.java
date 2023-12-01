import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // приветствие и количество гостей
        System.out.println("Здравствуйте! На скольких человек необходимо разделить счёт?");
        // глобальные переменные
        int amountPeople = scanner.nextInt();
        double totalSum;
        // бесконечный цикл и выход при количестве гостей больше 1.
        while (amountPeople <= 1) {
            System.out.println("Это некорректное количество гостей, попробуйте снова.");
        break;
        }

        // сам калькулятор
        while (true) {
            System.out.println("Введите название товара:");
            String inputFood = scanner.nextLine();
            if () {

            }

            System.out.println("Введите сумму товара:");
            double inputPrice = scanner.nextDouble();
            if () {

            }

            Food food = new Food(inputFood, inputPrice);

            System.out.println("Товар успешно добавлен. Хотите добавить ещё товар? или " +
            "введите \"Завершить\", чтобы завершить процесс добавления товара");
            String inputEnd = scanner.nextLine();

            if (inputEnd.equalsIgnoreCase("Завершить")) {
                scanner.close();
                break;

            }

        }
    }


    // классы:
    public class Calculator {
        double totalPrice;
    }

    public class Food {
        String nameFood;
        double priceFood;

        Calculator(String name, double price) {
            nameFood = name;
            priceFood = price;
        }
    }

    // методы:
}