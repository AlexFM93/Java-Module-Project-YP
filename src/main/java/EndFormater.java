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