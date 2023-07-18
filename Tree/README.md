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

*Two Restrictions for Trees:*
1. No duplicate references allowed
2. No reference points back to root

### Binary Tree

A binary tree is a tree where a node can have at most two children.
If every leaf is at the same depth, we have a **full binary tree**. <br>
(-- For a full binary tree, we have 2^n nodes at the last level, and 2^(n+1) - 1 nodes in total)
If every level except the last is full, and all leaf nodes at the last level are as left as possible, we have a **complete binary tree**.

## Tree Traversal

We use the term "traverse" to distinguish it from the linear-nature of "iterate".

**Preorder** - work on current node, then recurse to left, then recurse to right
**Postorder** - Perform work at current node AFTER preforming it on left and right children

