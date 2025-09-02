public class lt_08_StringToInteger {
    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') i++;
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        long res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * res);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));         
        System.out.println(myAtoi("   -42"));     
        System.out.println(myAtoi("1337c0d3"));   
        System.out.println(myAtoi("0-1"));        
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("91283472332")); 
    }
}
