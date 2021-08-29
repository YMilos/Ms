package Calculator;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // We ask the user to enter data to the console, separated by a space
        System.out.println("Enter integers from 0 to 10 separated by a space");
        Scanner sc = new Scanner(System.in);
        // read the line and move it to upper case
        String EnteredString = sc.nextLine().toUpperCase();
        // dividing the string
        String[] arr = EnteredString.split(" ");
    //    System.out.println(arr.length);
        if (arr.length > 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        } else if (arr.length < 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией");
                System.exit(0);
            }
                // сравниваем введенные данные с римскими числами
            }
            if (ComparisonRome.comparisonRome(arr[0]) && ComparisonRome.comparisonRome(arr[2])) {
                int number1 = RomeNumbers.romeNums(arr[0]);
                int number2 = RomeNumbers.romeNums(arr[2]);
                char arthS = arr[1].charAt(0);
                System.out.println(ArabicToRomes.transformNumberToRomanNumeral(Result.result(number1, number2, arthS)));
            }
            else if ((!(ComparisonRome.comparisonRome(arr[0])) && ComparisonRome.comparisonRome(arr[2])) || (ComparisonRome.comparisonRome(arr[0]) && !(ComparisonRome.comparisonRome(arr[2])))){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                    System.exit(0);
                }
            }
            else {
                // converting string to int
                int number1 = Integer.parseInt(arr[0]);
                int number2 = Integer.parseInt(arr[2]);
                // read the arithmetic symbol
                char arthS = arr[1].charAt(0);
                // calculate the results by result method
                System.out.println(Result.result(number1, number2, arthS));
            }

        }
    }

    class Result {
        static int result(int number1, int number2, char arthS) {
            int x = 0;
            switch (arthS) {
                case '+' -> x = number1 + number2;
                case '-' -> x = number1 - number2;
                case '*' -> x = number1 * number2;
                case '/' -> x = number1 / number2;
                default -> {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("throws Exception //т.к. строка не является математической операцией");
                        System.exit(0);
                    }
                }
            }
            return x;
        }
    }

    class ComparisonRome {
        static boolean comparisonRome(String rWords) {
            if (rWords.equals("I") || rWords.equals("II") || rWords.equals("III") || rWords.equals("IV") ||
                    rWords.equals("V") || rWords.equals("VI") || rWords.equals("VII") || rWords.equals("VIII") ||
                    rWords.equals("IX") || rWords.equals("X")) {
                return true;
            } else if (rWords.equals("0") || rWords.equals("1") || rWords.equals("2") || rWords.equals("3") || rWords.equals("4") ||
                    rWords.equals("5") || rWords.equals("6") || rWords.equals("7") || rWords.equals("8") ||
                    rWords.equals("9") || rWords.equals("10")) {
                return false;
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception // т. к. принимаются числа от 0 до 10");
                    System.exit(0);
                }
            }
            return false;
        }
    }

    class RomeNumbers {
        static int romeNums(String rWords) {
            int rm = switch (rWords) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "XX" -> 10;
                default -> 0;
            };
            return rm;
        }
    }

    class ArabicToRomes {
        public static String transformNumberToRomanNumeral(int number) {
            int[] romanValueList = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romanList = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder res = new StringBuilder();
            if (number <= 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    System.exit(0);
                }
            }
            for (int i = 0; i < romanValueList.length; i += 1) {
                while (number >= romanValueList[i]) {
                    number -= romanValueList[i];
                    res.append(romanList[i]);
                }
            }
            return res.toString();
        }
    }


