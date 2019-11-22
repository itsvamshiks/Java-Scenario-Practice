import java.util.HashMap;
import java.util.Map;

public class LetterCount {
    public static void main(String[] args) {
        CountCalculator countCalculator = new CountCalculator();
        System.out.println(countCalculator.letterCountSum(101));
    }
}

class CountCalculator{
    private static Map<Integer,Integer> countMap = new HashMap<Integer, Integer>();
    static {
        countMap.put(0,4);
        countMap.put(1,3);
        countMap.put(2,3);
        countMap.put(3,5);
        countMap.put(4,4);
        countMap.put(5,4);
        countMap.put(6,3);
        countMap.put(7,5);
        countMap.put(8,5);
        countMap.put(9,4);
        countMap.put(10,3);
        countMap.put(11,6);
        countMap.put(12,6);
        countMap.put(13,8);
        countMap.put(14,8);
        countMap.put(15,7);
        countMap.put(16,7);
        countMap.put(17,9);
        countMap.put(18,8);
        countMap.put(19,8);
        countMap.put(20,6);
        countMap.put(30,6);
        countMap.put(40,5);
        countMap.put(50,5);
        countMap.put(60,5);
        countMap.put(70,7);
        countMap.put(80,6);
        countMap.put(90,6);
        countMap.put(100,7);
        countMap.put(200,10);
    }

    public int letterCountSum(int number){
        int count=0;

        if(number<0) {
            number = Math.abs(number);
            count+=5*number;
        }

        for(int i=0;i<=number;i++){
            if(countMap.containsKey(i))
                count+=countMap.get(i);
            else {
                //System.out.println(i);
                count += letterCount(i);
            }
        }



        return count;
    }

    public int letterCount(int number){
        int count=0;
        if(number<0) {
            count+=5;
            number = Math.abs(number);
        }
        int divider = (int) Math.pow(10,getLength(number)-1);
        int mod = number%divider;
        count+= countMap.get(number-mod);
        if(mod!=0 && countMap.containsKey(mod)){
            count += countMap.get(mod);
        }else if(mod!=0){
            count+=letterCount(mod);
        }
        countMap.put(number,count);

        return count;
    }

    public int getLength(int number){

        return Integer.toString(number).length();

    }

}