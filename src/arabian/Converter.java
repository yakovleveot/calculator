package arabian;
import java.util.TreeMap;
class Converter {
   TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
   TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    Converter(){
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }
    boolean isRoman(String number){
        return romanKeyMap.containsKey(number.charAt(0));
    }
    String intToRoman(int number){
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
    }
    int romanToInt(String s){
        int res = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            int curr = romanKeyMap.get(s.charAt(i));
            if (curr < prev){
                res -= curr;
                } else {
                res += curr;
            }
            prev = curr;
        }
        return res;
    }
}
