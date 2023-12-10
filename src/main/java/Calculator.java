class Calculator {
    String names = "";
    double price;

    void calculate(String inputName, double inputPrice) {
        StringBuilder builder = new StringBuilder();
        builder.append(names += "\n" + "\"" + inputName + "\"");
        builder.append(price += inputPrice);
    }
}