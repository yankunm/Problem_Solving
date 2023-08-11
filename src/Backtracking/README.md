# Backtracking

Backtracking is a Depth-First-Search on the graph of ALL possible partial solutions.

The basic idea is to perform Exhaustive Search while doing as little work as possible, and when hitting a deadend, backtrack to the previous state to continue.

General Scheme:
1. Repeatedly Test if the solution so far is correct <br>
2. If not correct: see if we can extend the solution <br>
3. If can't extend solution: recur to previous state <br>

## Pseudocode

Backtrack(a[], k, input){ <br>
    c[] = {} <br>
    numC = 0 <br>
    if(is_a_solution(a, k, input) <br>
        process_solution(a, k, input); <br>
    else  <br>
      k = k + 1 <br>
        construct_candidates(a, k, input, c, numC);  <br>
        for(i = 0; i < numC; i++){ <br>
            a[k] = c[i] <br>
            backtrack(a, k, input) <br>
           if(finished) <br>
              return <br>


is_a_solution: 

Boolean function tests whenter the first k elements of vector a are a complete solution for the given problem.

process_solution:

Once you have a solution, do whatever you want in this routine.

construct_candidates:

Fill array c with the complete set of possible candidates for the kth position of a, given the contents of the first k - 1 positions.


