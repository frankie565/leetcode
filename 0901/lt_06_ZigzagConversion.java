public class lt_06_ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int idx = 0, step = 1;
        for (char c : s.toCharArray()) {
            rows[idx].append(c);
            if (idx == 0) step = 1;
            else if (idx == numRows - 1) step = -1;
            idx += step;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); 
        System.out.println(convert("PAYPALISHIRING", 4)); 
        System.out.println(convert("A", 1));              
    }
}
