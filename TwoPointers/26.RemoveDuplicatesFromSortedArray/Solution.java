class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int saved = 1;
        if(nums[0] != nums[1]){
            saved = 2;
        }
        for(int tr = saved; tr < nums.length; tr++){
            if(nums[tr] != nums[tr - 1]){
                nums[saved] = nums[tr];
                saved++;
            }
        }
        return saved;
    }
}
