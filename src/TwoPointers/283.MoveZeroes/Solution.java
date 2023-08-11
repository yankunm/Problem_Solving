class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }
}

/**
[1,3,12,0,0]
        i 
          j

[2, 1]
 i
 j




 Traverse using j, Everything before i, is non-zero.

i, j = 0
For every element in nums
    If nums[j] == 0 then move j forward
    else swap(nums[i], nums[j]) and move i forward 

Time: O(n)
Space: O(1)

 */
