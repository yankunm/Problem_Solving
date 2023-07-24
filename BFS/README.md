# Breadth-First Search

Using the concept of "level", we use a queue to store the nodes that *need expanding*.

## Tree BFS

1. Initialize Queue with **all entry points**: <br>
2. While *queue is not empty*: <br>
     a. for each node in queue (current level) <br>
     b. poll out the element (add to result) <br>
     c. expand it, offer children (next level) to the queue *in order* (depends on question) <br>
     d. (*go to next level*) <br>

Look at each node in queue, take it out, use it in some way, and "expand it". <br>

**Expanding a node** means directly looking at children of a node. <br>

