import java.util.*;


public class lt_01_twosum {
    public static int[] lt_01_twosum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) {
                return new int[]{ seen.get(need), i };
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No valid answer"); 
    }

    public static void main(String[] args) {
        int[] ans1 = lt_01_twosum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ans1)); 

        int[] ans2 = lt_01_twosum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ans2)); 

        int[] ans3 = lt_01_twosum(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(ans3)); 
    }
}
