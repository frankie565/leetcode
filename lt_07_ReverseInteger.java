public class lt_07_ReverseInteger {
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int d = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && d > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && d < -8)) return 0;
            res = res * 10 + d;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));   
        System.out.println(reverse(-123));  
        System.out.println(reverse(120));   
        System.out.println(reverse(1534236469)); 
    }
}
