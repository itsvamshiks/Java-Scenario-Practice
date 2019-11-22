public class stringReverse {
    public static void main(String[] args) {
        stringReverse rev = new stringReverse();
        String reverse = rev.reverseString("Vamshi");
        System.out.println(reverse);

    }
    public String reverseString(String s){
        char[] reverse = new char[s.length()];
        int len = s.length();
        char[] sarr = s.toCharArray();
        for(int i=0;i<reverse.length;i++){
            reverse[i] = sarr[len-i-1];
        }
        return String.valueOf(reverse);
    }
}
