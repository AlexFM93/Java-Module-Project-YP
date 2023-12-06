class Calculator {
    String names = "";
    double price;

    void calculate(String inputName, double inputPrice) {
        names = names + "\n" + "\"" + inputName + "\"";
        price += inputPrice;
    }
}