# 344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

_________________________________________________________________-

Intuition 1: Two pointers going in opposite directions

Initialize i = 0, j = s.length - 1
while i <= j:
    swap(s[i], s[j])
    advance i, j
