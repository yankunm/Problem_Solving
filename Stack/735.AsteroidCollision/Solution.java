class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Initialization 
        Deque<Integer> pastAst = new ArrayDeque<>();

        // Loop
        for(int ast: asteroids){
            // if ast is positive
            if(ast > 0) {
                pastAst.push(ast);
            } else { // AST < 0
                // Collide until can't anymore
                while(!pastAst.isEmpty() && pastAst.peek() > 0 && pastAst.peek() < Math.abs(ast)){
                    pastAst.pop();
                }
                // check if peek value is equal (Becareful with null access)
                if(pastAst.size() > 0 && pastAst.peek() == Math.abs(ast)){
                    pastAst.pop();
                } else if(pastAst.size() <= 0 || pastAst.peek() < 0){ // if pastAst is empty or the top value is same sign and we should not discard this asteroid
                    pastAst.push(ast);
                }
            }
        }

        // Finalize
        int[] answer = new int[pastAst.size()];
        for(int i = answer.length - 1; i >= 0; i--){
            answer[i] = pastAst.pop();
        }
        return answer;
    }
}

/**

Scheme:

INITIALIZE STACK
FOR EACH ARR[i]:
    IF arr[i] > 0 THEN push to stack
    ELSE keep popping until empty or top < 0
    IF equal THEN pop
    ELSE push arr[i] to stack if survived
FILL ANSWER ARRAY FROM STACK

[10, 8, 2, -8, -5]



10
______




Intuition 1:

Find: all asteroids that will survive collision

collision: (positive, negative) cancels out (either one)

Isn't this the valid parentheses problem?

Stack definition: Store asteroids that will survive in a stack. we want LIFO, 
because asteroids collide from right (last entered) to left (first entered).

Why do we want to use a stack?

Because we have to look back at the IMMEDIATE past values.
_______________________________

1. Graphics

[10, 2, -5]
 i


3
10
____

In what conditions do we pop? 
    When encountered number is negative
    AND it's magnitude is bigger than or equal to stack.peek element

In what conditions do we push?
    





Observations:

In the end, all negatives are left of positives in the array.
OR all array elements are negative/positive

Ex 3:
[10, 2, -5] IN A ROW

----------> --> <-----

Final State:

---------->

[10]

----------------------------------
Ex 2:
[8, -8] IN A ROW

--------> <--------

Final State:

[]

----------------------------------

Ex 1:
[5,10,-5] IN A ROW

1st asteroid: size of 5 and going to the right
2nd asteroid: size of 10 and going to the right
3rd asteroid: size of 5 and going to the left

Smaller will explode. If equal, both will explode

  ----->      ---------->      <-----

Final State:

  ----->      ----------> 

[5, 10]



 */

