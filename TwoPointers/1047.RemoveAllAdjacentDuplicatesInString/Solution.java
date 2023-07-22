class Solution {
    public String removeDuplicates(String s) {
        // Initialize Stack
        Deque<Character> stack = new ArrayDeque<>();

        // Push characters to stack
        for(int i=s.length() - 1; i >= 0; i--){
            if(!stack.isEmpty() && s.charAt(i) == stack.peek()){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        // Build answer string
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        return answer.toString();
    }
}

/**
Approach 2: Stack

GO FROM BACK FORWARD.

[a, b, b, a, c, a]

a
c
___

Initialize Stack
If current == top: pop
else push current

Approach 1: Two Pointers

public String removeDuplicates(String s) {
        // Convert s to a character array
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 1;
        while(j < arr.length){
            if(i >= 0 && arr[i] == arr[j]){
                i--;
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        // Build the answer
        StringBuilder answer = new StringBuilder();
        for(int c=0; c <= i; c++){
            answer.append(arr[c]);
        }
        return answer.toString();
    }



left pointer acts as the boundary for the saved section.
  1 Everytime we encounter adjacent duplicates, s[l] == s[r],
  2 we need to make left go back and make right go forward. (Skip the duplicates and not put them in the saved section)
  3 If s[l] != s[r] or left ran out of boundary, we can advance left pointer, swap it with right pointer, and advance right pointer.

"abbaca"
"aaca"
"ca" --> answer

"azxxzy"
"azzy"
"ay" --> answer

"abbaca"
[a, b, b, a, c, a]
 i
 j

Intuition 1: Loop until no duplicates

1. Find duplicates and remove them
    (swap characters in the back to the front)
2. Repeat until no more duplicates exist

Repeat at most n/2 times, each time taking n characters. 
--> O(n^2) time



 */
