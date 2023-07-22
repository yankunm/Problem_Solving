# 1047. Remove All Adjacent Duplicates In String

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

____________________________________________________

Approach: Two Pointers

1. Define how far they are apart - length of duplicate sequence 
2. Define their traversal speed - same speed

left pointer acts as the boundary for the saved section.
Everytime we encounter adjacent duplicates, s[l] == s[r],
we need to make left go back and make right go forward. (Skip the duplicates and not put them in the saved section)
If s[l] != s[r] or left ran out of boundary, we can advance left pointer, swap it with right pointer, and advance right pointer.


   [a, b, b, a, c]
    i        j        


"cabaca"
  i 
       j 

____________________________________________________

Approach: Stack

GO FROM BACK FORWARD.

[a, b, b, a, c, a]

Initialize Stack
If current == top: pop
else push current
