class Solution {
    private double myPowHelper(double x, long n) {

        if(n == 0) return 1.0;

        if(n < 0){ return 1.0 / myPowHelper(x, -n);}

        if(n%2 == 0){
            return myPowHelper(x*x, n/2);
        } else {
            return x * myPowHelper(x*x, (n-1)/2);
        }
    }

    public double myPow(double x, int n){
        return myPowHelper(x, (long) n);
    }
}

/**

APP 1: 

multiply x n times.

Base case: if n is 0 then return 1

if n > 0:

x * pow(x, n - 1)

if n < 0:

1 / pow(x, -n)


pow(2, -2)

1/2 * 1/2 = 1/4 = 1 / pow(2, 2)

 */
