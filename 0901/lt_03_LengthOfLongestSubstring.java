
public class lt_03_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];
        int left = 0, ans = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right);
            left = Math.max(left, last[c]);
            ans = Math.max(ans, right - left + 1);
            last[c] = right + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(lengthOfLongestSubstring("bbbbb"));    
        System.out.println(lengthOfLongestSubstring("pwwkew"));   
        System.out.println(lengthOfLongestSubstring(""));         
        System.out.println(lengthOfLongestSubstring("dvdf"));     
    }
}
