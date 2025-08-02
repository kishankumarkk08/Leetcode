class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for binary search efficiency
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int halfLen = (m + n + 1) / 2;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = (left + right) / 2;          // partition in nums1
            int j = halfLen - i;                // corresponding partition in nums2

            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // Correct partition found
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                } else {
                    int leftMax = Math.max(nums1LeftMax, nums2LeftMax);
                    int rightMin = Math.min(nums1RightMin, nums2RightMin);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (nums1LeftMax > nums2RightMin) {
                // i is too big
                right = i - 1;
            } else {
                // i is too small
                left = i + 1;
            }
        }

        // Should not reach here if input arrays are sorted
        throw new IllegalArgumentException("Input arrays are not sorted or of invalid size.");
    }
}