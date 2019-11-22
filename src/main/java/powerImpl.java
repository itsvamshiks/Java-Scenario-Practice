public class powerImpl {
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        System.out.println(power(x,y));
    }

    public static int power(int x,int y){
        if(y==0)
            return 1;
        else if(y%2==0)
            return power(x,y/2)*power(x,y/2);
        else
            return x*power(x,y/2)*power(x,y/2);
    }
}
