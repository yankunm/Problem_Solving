# 496. Next Greater Element I

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

_______________________________________________________________

Intuition 1: Stack + HashMap

nums1 = [4,1,2]
    i:   0 1 2
nums2 = [1,3,4,2]
    j:   0 1 2 3

ans = [-1, 3, _]


For each element in nums1 O(n)
Find it's index in num2 O(n)
Find the "next greater element of nums2[j]" O(n)


Traverse all elements of nums2 using stack and get the next greater for each element, then store them, inside the hash table.

Stack definition: Store all elements to the right of nums2[j] in descending order

Store these inside a hash table:
(1, 3)
(2, 4)
(4, -1)
(2, -1)

Time: O(max(nums2.length, nums1.length))
Space: O(nums2.length)

// Build monotone decreasing stack (O(nums2.length))
Initialize Stack
For all element x of nums2 backwards:
    while(stack is not empty and top element < current element)
        pop
    push element x into stack

// Pop all stack elements and put them inside hash table along with the next greater element
Initialize Hash Table (O(num1.length))
if(stack not empty)
    int key = stack.pop()
while(stack is not empty)
    int value = stack.pop()
    Store (key, value) into Hash Table
    key = value;

// Build answer array (O(nums1.length))
For all element x of nums 1:
    if(map has x as a key):
        ans[i] = x.value()
    else
        ans[i] = -1


