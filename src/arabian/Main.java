package arabian;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, IllegalStateException {
        System.out.println();
        System.out.print("Введите два операнда и один оператор (+, -, /, *) через пробел: ");
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        String eq = in.trim();
        System.out.println(calc(eq));
    }
    public static String calc(String input) throws IOException, IllegalStateException {
        Converter converter = new Converter();
        String[] symbols = {"+", "-", "/", "*"};
        int symbolIndex = -1;
        for (int i = 0; i < symbols.length; i++){
            if(input.contains(symbols[i])){
                symbolIndex = i;
                break;
            }
        }
        if(symbolIndex==-1){
            throw new IllegalStateException ("Пожалуйста введите корректный оператор (+, -, /, *)");
        }
        String[] data = input.split(" ");
        if (data.length != 3){
            throw new IOException("Пожалуйста введите два операнда и один оператор (+, -, /, *)");
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
                    throw new IOException("Пожалуйста вводите числа от 1 до 10");
                } else {
                    int result;
                    switch (data[1]) {
                        case "+" -> result = a + b;
                        case "-" -> result = a - b;
                        case "*" -> result = a * b;
                        case "/" -> result = a / b;
                        default -> throw new IllegalStateException("Пожалуйста введите корректный оператор (+, -, /, *)");
                    }
                    if (isRoman) {
                        if (result <= 0) {
                            throw new IOException("В римской системе нет 0 и отрицательных чисел");
                        } else
                            return "Ответ: "+converter.intToRoman(result);
                    } else {
                        return "Ответ: "+result;
                    }
                }
            } else {
                throw new IOException("Пожалуйста, используйте числа в одной исчислительной системе");
            }
        }
    }
}