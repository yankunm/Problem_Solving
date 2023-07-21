class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Build Monotonic Decreasing Stack for Next Greater Element
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Store stack elements into Hash Table (key=element, value=element's next greater element)
        
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
    
        while (!stack.isEmpty())
            map.put(stack.pop(), -1);
    
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
                                            
        return res;
    }
}


/**

Iterate nums2 from left to right using stack
For each popped element, you put it with its next greater number 

[1,3,5,2,4]
[6,5,4,3,2,1,7]




7
_____



// Build monotone decreasing stack (O(nums2.length))
Initialize Stack
Initialize Hash Table
For all element x of nums2:
    while(stack is not empty and top element < current element)
        pop

    push element x into stack

// Pop all stack elements and put them inside hash table along with the next greater element
if(stack not empty)
    int key = stack.pop()
while(stack is not empty)
    int value = stack.pop()
    Store (key, value) into Hash Table
    key = value







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








For each element in nums2:
    while stack is not empty and


4 --> i = 0, j = 2 --> no next greater element
1 --> i = 1, j = 0 --> 3
2 --> i = 2, j = 3 --> no next greater element

Task: For each 4, 1, 2, find its index j  in nums2, and store the "next greater element of nums2[j]" in ans

 */
