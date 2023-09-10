# 33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.


________________________________________________________________

Intuition 1: Modified Binary Search

Normal Binary Search:
1. pick pivot, if it is target then return
2. If current > pivot recurse right
3. If current < pivot recurse left
4. Repeat until the left pointer and right pointer crosses

1. Search for the boundary (the cut) (O(log n))
2. using the boundary, decide in constant which side
the target is in (O(1))
3. then use binary search on that half (O(log n))


