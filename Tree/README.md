# Tree

## Introduction
 
Trees are the most fundamental data structure in Computer Science. We will study how trees are used to evaluate arithemetic expressions, support logarithmic operations in data collections, and refine search operations to logarithmic time. **Binary Search Trees** are the foundations of **TreeSet and TreeMap** structures in Java.

## History

First person to study about trees - Arthur Cayley (British Mathematician, 1857) <br>
[AVL trees: first self-balancing BST](https://www.mathnet.ru/php/archive.phtml?wshow=paper&jrnid=dan&paperid=26964&option_lang=eng) - Georgy Adelson-Velsky, Evgenii Landis (Soviet Computer Scientists, 1962) <br>
[2-3-4 trees](https://link.springer.com/article/10.1007/BF00289509) - Rudolf Bayer (German Computer Scientist, 1972) <br>
[Red-Black Trees](https://ieeexplore.ieee.org/abstract/document/4567957) - Leonidas J. Guibas, Robert Sedgewick (American Computer Scientists, 1978)


## Definition

### Tree
tree ::== nil | \<val\>\<tree\>\<tree\>...\<tree\>

A tree could be empty, or it could have a root node **r** with non-empty subtrees T1, T2, ..., Tn.

*Two Restrictions for Trees:* <br>
1. No duplicate references allowed <br>
2. No reference points back to root

### Binary Tree

A binary tree is a tree where a node can have at most two children.
If every leaf is at the same depth, we have a **full binary tree**. <br>
(-- For a full binary tree, we have 2^n nodes at the last level, and 2^(n+1) - 1 nodes in total) <br>
If every level except the last is full, and all leaf nodes at the last level are as left as possible, we have a **complete binary tree**.

## Tree Traversal

We use the term "traverse" to distinguish it from the linear-nature of "iterate".

We can go "left", "right", or "up" (to the parent).

**Preorder** - work on current node, then recurse to left, then recurse to right <br>
**Postorder** - Perform work at current node AFTER preforming it on left and right children <br>
**Inorder** - From left to right

## Binary Search Trees

BSTs are used for sublinear O(log n) searching, insertion, and deletion.

*Two Properties for BST:* <br>
For all nodes N: <br>
1. All nodes in its left subtree are smaller <br>
2. All nodes in its right subtree are bigger

Search: <br>
1. If higher go right <br>
2. If lower go left <br>
3. If equal return

Insertion: <br>
1. If lower go left <br>
2. If higher go right <br>
3. If null then insert

**The only reason why we would use binary search trees over hash tables is that it maintains order**.

### Sucessor of node N

Sorted Array: \[___, N, successor\]

### Predecessor of node N

Sorted Array: \[predecessor, N, ___\]







## Evaluating Basic Arithmetic Expressions

+, -, *, / are binary operators. Each takes two inputs and give one output.

**Infix Expression** - \<arg1\> \<operator\> \<arg2\> (1 + 1)

To represent (a*(b + c)) + (((d - e)/f) * g), we should use a binary tree.

If we traverse the tree INORDER, we get the INFIX expression. 

Infix notation is easier for humans, but is ambiguous sometimes (require PEMDAS and parentheses to know order). <br>
Prefix and postfix notations are easier for computers, because they do not require *precedence* (PEMDAS) or *parentheses* to evaluate.

To compute an expression, we can use two stacks, an *operand* stack and an *operator* stack. 

Compute(): <br>
1. pop() from operator stack and store it as *op* <br>
2. pop() twice from operand stack and store them as *arg1* and *arg2* <br>
3. evaluate *arg1* *op* *arg2* and push() result onto operand stack <br>
4. Repeat steps 1-3 until operator stack is empty









