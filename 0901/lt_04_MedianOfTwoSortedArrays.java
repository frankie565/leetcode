public class lt_04_MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m, half = (m + n + 1) / 2;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;
            int l1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int r1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int l2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int r2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) 
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else 
                    return Math.max(l1, l2);
            } else if (l1 > r2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));    
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));  
        System.out.println(findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));  
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));       
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));       
    }
}
