# Pow(x,n) (Medium)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

____________________________________________________

Fast Exponentiation: Binary Exponetiation (Repeated Doubling Problem)

Recurrence relation: x^n = x * x^(n-1) 

T(n) = T(n - 1) + 1

**Binary Exponentiation** -- Exponentiation by squaring -- a divide-and-conquer idea to quickly compute power of a number.

x^n = (x^2)^(n/2) if n is even

x * (x^2)^((n-1)/2) if n is odd


2^100 = 2 * 2 ^99

2 ^ 99 = 2 * 2 ^ 98 

... (100 steps)

INSTEAD USING EXPONENTIATION BY SQUARING

2^100 = ( 2^2 )^50

4^50 = (4^2 )^25

... (10 steps)



O-M-G, and x=2 n=-2147483648 testcase fails if you don't convert n into a long, why?
I'll let you think
.
.
.
.
.
.
.
.
.
Because if you multiply Integer.MIN_VALUE * -1, you get an overflow, as min value is -2^31, but Integer.MAX_VALUE is 2^31 - 1, it's -1 because you gotta hold 0 that side of the int.
I find this exercise is HARD!
