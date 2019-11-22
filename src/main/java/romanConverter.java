import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

public class romanConverter {
    public static void main(String[] args) {
        RomanToNumber romanToNumber = new RomanToNumber();
        System.out.println(romanToNumber.convertRoman("MCMIV"));
    }
}


class RomanToNumber{
    private Map<Character,Integer> map;

    RomanToNumber() {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }


    public int convertRoman(String romanString) throws NullPointerException{
        int result = 0;

        try {
            if(romanString.equals(null))
                throw new NullPointerException();
        }catch (NullPointerException e){
            System.out.println("Null String received");
            return -1;
        }

        //ask if small letters are allowed too in the string. Now assuming string should have only capital letters
        if(!Pattern.matches("[A-Z]+",romanString)){
            System.out.println("Please enter valid input string");
            return -1;
        }

        for(int i=0;i<romanString.length();i++){
            int s1 = map.get(romanString.charAt(i));
            if(i+1<romanString.length()){
                int s2 = map.get(romanString.charAt(i+1));
                if(s1>=s2){
                    result = result + s1;
                }else{
                    result = result + s2-s1;
                    i++;
                }
            }else{
                result = result + s1;
                i++;
            }

        }
        return result;
    }
}
