import java.util.Scanner;

public class NumberIntoWords {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextShort();
        String result="";
        if (number<0||number>=1000)result = "Out of ability";
        if (number <= 10 && number >= 0) {
            if (number == 0) result = "zero";
            else result = checkUnits(number);
        }
        if (number < 20 && number > 10) {
            result = checkTeen(number);
        }
        if (number >= 20 && number <= 99) {
            result = checkTens(number) + checkUnits(number % 10);
        }
        if (number >= 100 && number < 1000) {
            if (number % 100 <= 10) {
                result = checkHundreds(number) + " and " + checkUnits(number - (number / 100) * 100);
            }
            else if (number% 100 > 10 && number% 100 < 20) {
                result = checkHundreds(number) + " and " + checkTeen(number - (number / 100) * 100);
            }
            else if (number% 100 >= 20) {
                result = checkHundreds(number) + " and " + checkTens(number - (number / 100) * 100) + " " + checkUnits(
                        (number - (number / 100) * 100) % 10);
            }
        }
        System.out.print(result);
    }

    public static String checkHundreds(int number) {
        int hundreds = number / 100;
        String hundredsStr;
        switch (hundreds) {
            case 1:
                hundredsStr = checkUnits(hundreds) + " hundred";
                break;
            default:
                hundredsStr = checkUnits(hundreds) + " hundreds";
                break;
        }
        return hundredsStr;
    }

    public static String checkTens(int number) {
        int tens = number / 10;
        String tensStr;
        switch (tens) {
            case 2:
                tensStr = "twenty";
                break;
            case 3:
                tensStr = "thirty";
                break;
            case 5:
                tensStr = "fifty";
                break;
            default:
                tensStr = checkUnits(tens) + "ty";
                break;
        }
        return tensStr;
    }

    public static String checkTeen(int number) {
        String teen;
        switch (number) {
            case 11:
                teen = "eleven";
                break;
            case 12:
                teen = "twelve";
                break;
            case 13:
                teen = "thirteen";
                break;
            case 15:
                teen = "fifteen";
                break;
            default:
                teen = checkUnits(number - 10) + "teen";
                break;
        }
        return teen;
    }

    public static String checkUnits(int number) {
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        return units[number];

    }
}
