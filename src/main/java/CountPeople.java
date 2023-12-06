import java.util.Scanner;

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