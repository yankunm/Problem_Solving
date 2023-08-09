# Binary Search

A search technique used on a sorted collection of dataset. (Most commonly used on **sorted arrays**)

**High Level Idea:**

1. while *some pointer condition*: <br>
  a. Extract mid *correctly* <br>
  b. Manipulate pointers or return based on mid element <br>

*Note: Binary search could have lots of variations based on what you are searching for (A number, A boundary, A range, etc.)*

## Two Fundamental Principles of Binary Search

When we design search algorithms, we must follow these two rules: <br>
1. *Shrink* the search space at every iteration/state <br>
2. Cannot exlude any potential answers for each *Shrinking* <br>

## Looking for an Explcit Value

1. while **l <= r**: <br>
  a. Extract mid *correctly* <br>
  b. Manipulate pointers: **l = mid + 1 OR r = mid - 1**

## Looking for an Implicit Value

## Looking for any value could work


  
