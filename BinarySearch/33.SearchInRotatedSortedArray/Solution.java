class Solution {

    // O(log n)
    // Assume nums.length in [1, 5000]
    private int findPivotIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int last = nums.length - 1;

        // If nums has not been rotated
        if(nums[left] < nums[right] || nums[left] == nums[right])
            return 0;

        // Loop tclass Solution {

    // O(log n)
    // Assume nums.length in [1, 5000]
    private int findPivotIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int last = nums.length - 1;

        // If nums has not been rotated
        if(nums[left] < nums[right] || nums[left] == nums[right])
            return 0;

        // Loop to find pivot index
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[last])
                left = mid + 1;
            else if(nums[mid] < nums[last])
                right = mid - 1;
            else
                return last;
        }

        // After they cross, left is pointing at index of pivot
        return left;
    }


    // O(log n)
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        
        // Get the pivot index in nums
        int pivotIndex = findPivotIndex(nums); // O(log n)

        // If array is not rotated
        if(pivotIndex <= 0)
            return binarySearch(nums, 0, nums.length - 1, target); // O(log n)
        
        // Remember: pivotIndex could be last
        
        if(nums[0] < target){
            return binarySearch(nums, 0, pivotIndex - 1, target); // O(log n)
        } else if(nums[0] > target){
            return binarySearch(nums, pivotIndex, nums.length - 1, target); // O(log n)
        } else {
            return 0;
        }
    }
}

/**
1. Binary Search to find the pivot
2. Binary Search on the correct half to find, if not found return -1
 */o find pivot index
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[last])
                left = mid + 1;
            else if(nums[mid] < nums[last])
                right = mid - 1;
            else
                return last;
        }

        // After they cross, left is pointing at index of pivot
        return left;
    }


    // O(log n)
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        
        // Get the pivot index in nums
        int pivotIndex = findPivotIndex(nums); // O(log n)

        // If array is not rotated
        if(pivotIndex <= 0)
            return binarySearch(nums, 0, nums.length - 1, target); // O(log n)
        
        // Remember: pivotIndex could be last
        
        if(nums[0] < target){
            return binarySearch(nums, 0, pivotIndex - 1, target); // O(log n)
        } else if(nums[0] > target){
            return binarySearch(nums, pivotIndex, nums.length - 1, target); // O(log n)
        } else {
            return 0;
        }
    }
}

/**
1. Binary Search to find the pivot
2. Binary Search on the correct half to find, if not found return -1
 */
