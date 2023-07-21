# 20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

______________________________________________________________________________________________

Intuition 1: Stack

Stack Definition: Store past left brackets on the left of s.charAt(i) 

Is there any cases you can think of, that we see a right bracket and the top of stack wouldn't pair with it?

Not any that's valid.


stack = initialize stack
for each character in String:
  if right bracket and not not pair with stack.top then return false
    else if right bracket and pairs with stack.top then pop top
      else push
If stack still has elements then return false
else return true;


