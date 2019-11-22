import java.util.HashMap;

public class MonotonousArrayCheck {
    public static void main(String[] args) {
        int[] testarr = {1,2,3,4,3,6,7,8};
        System.out.println(MonotonocityChecker.isMonotonous(testarr));
    }
}

class MonotonocityChecker {
    public static boolean isMonotonous(int[] arr){
        if(arr.length<=2)
            return true;

        boolean increasing = true,decreasing = true;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i])
                increasing = false;
            else if(arr[i-1]<arr[i])
                decreasing = false;
        }
        return (!increasing && !decreasing);
    }
}