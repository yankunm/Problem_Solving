class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Initialize Hash Table to count characters in current substring
        HashMap<Character, Integer> count = new HashMap<>();
        int maxLength = 0, begin = 0, currLength = 0;;

        // Loop through each element in string
        for(int i = 0; i < s.length(); i++){
            // Extract character
            char curr = s.charAt(i);
            
            // Update HashMap count of curr character
            count.put(curr, count.getOrDefault(curr,0) + 1);

            // Update currlength
            currLength++;

            // While count of curr character is not unique
            while(count.get(curr) > 1){
                // Remove begin from count
                char beginning = s.charAt(begin);
                count.put(beginning, count.get(beginning) - 1);

                // Decrement length of current subarray
                currLength--;

                // Update beginning index
                begin++;
            }

            // Update maxLength at each iteration
            maxLength = currLength > maxLength ? currLength : maxLength;
        }

        // Finalize
        return maxLength;
    }
}

/**
a b c a b c b d
           
Intuition 1: Two Pointers + Hash Map

Traverse until encountered duplicate (map.get(num) > 1), move left pointer
forward and subtract count of left character from map.

High Level Idea:
1. Initialize Hash Table to store characters in current subarray, maxLength
2. For every character in the String:
    a. put the character into hashMap and increment count
    b. while the count of this character is greater than 1:
        i. decrement the count of character at beginning index
        ii. increment beginning index
    c. Update maxLength as HashMap.size()
3. Return maxLength

HashMap Definition: 
    Key: Next character encountered
    Value: Number of times it occurred

WRONG APPROACH. BAD QUESTION MODELING.

Intuition 1: Sequential Scan across String s

High Level Idea:
1. Initialize HashMap to store characters, length (longest substring length)
2. For each letter in substring:
    a. If character is not in hashMap
        i. Increment length, put character in Map
    b. else 
        i. Refresh length
    c. update global_max
3. Return length


 */
