package arabian;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.print("Введите два операнда и один оператор (+, -, /, *) через пробел: ");
        String input = s.nextLine();
        String eq = input.trim();
        String[] symbols = {"+", "-", "/", "*"};
        int symbolIndex = -1;
        for (int i = 0; i < symbols.length; i++){
            if(eq.contains(symbols[i])){
                symbolIndex = i;
                break;
            }
        }
        if(symbolIndex==-1){
            System.out.println("Ошибка. Используйте операторы (+, -, /, *)");
            return;
        }
        String[] data = eq.split(" ");
        if (data.length != 3){
            System.out.println("Ошибка. Введите два операнда и один оператор (+, -, /, *).");
        }else {
            if (converter.isRoman(data[0]) == converter.isRoman(data[2])) {
                int a, b;
                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[2]);
                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[2]);
                }
                if (a < 1 || a > 10 || b < 1 || b > 10) {
                    System.out.println("Ошибка. Пожалуйста вводите числа от 1 до 10.");
                } else {
                    int result;
                    switch (data[1]) {
                        case "+" -> result = a + b;
                        case "-" -> result = a - b;
                        case "*" -> result = a * b;
                        case "/" -> result = a / b;
                        default -> throw new IllegalStateException("Unexpected value: " + symbols[symbolIndex]);
                    }
                    if (isRoman) {
                        if (result <= 0) {
                            System.out.println("Ошибка. В римской системе нет 0 и отрицательных чисел.");
                        } else
                            System.out.println("Ответ: "+converter.intToRoman(result));
                    } else {
                        System.out.println("Ответ: "+result);
                    }
                }
            } else {
                System.out.println("Ошибка. Используйте числа в одной исчислительной системе.");
            }
        }
    }
}