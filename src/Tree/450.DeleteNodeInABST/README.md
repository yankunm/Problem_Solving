# 450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

1. Search for a node to remove.
2. If the node is found, delete the node.


## Thinking

Delete Nodes in a BST, such as a simple problem but I encountered a major problem. 

What was that problem?

MY BIGGEST MISTATE is I didn’t think of this line:

Root.left = deleteNode(root.left, key)

I could use the return value, the answer passed from my left subtree, and assign that to my left subtree, at the current level.

When doing recursive problems, pay attention to whether you want to assign the result of a subproblem or return it or basically what do you want to do with that result?

So my algorithm started off as searching for the node, and then after finding it, keep a reference to it, and try to delete it. THIS ALGORITHM IS INHERENTLY WRONG. Because how are you going to delete it only by keeping a reference to it? How can you set (if it is the left child) its parent’s left child pointer to null to delete it?

This is the tricky part, and here, to “access” the parent’s pov and delete the node from the parent’s pov, we need to go back to the previous STATE, that is the parent’s state.

I can start from the root, and recursively update my left subtree if the key is less than me, or recursively update my right subtree if the key is greater than me. My STATE is therefore which node I am at.

If the key is equal to me, that means I want to delete myself. Then this is simple, on the call stack my parents are already “below” me, so I only have to return something to my parents. 

If both of my children are null, then return null.

If my right child is null, return the left child.

If my left child is null, return the right child.

Else (both children are not null), I want to find the minimum in the right subtree, and change my value to that node’s value, and call deleteNode on that node with that node’s value.



